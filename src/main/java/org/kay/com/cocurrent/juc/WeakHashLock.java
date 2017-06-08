package org.kay.com.cocurrent.juc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 弱引用锁，为每个独立的哈希值提供独立的锁功能.
 *
 * @author kay
 * @version v0.0.1
 */
public class WeakHashLock<T> {
    private ConcurrentHashMap<T, WeakLockRef<T, ReentrantLock>> lockMap = new ConcurrentHashMap<>();
    private ReferenceQueue<ReentrantLock> queue = new ReferenceQueue<>();

    public ReentrantLock get(T key) {
        if (lockMap.size() > 1000) {
            clearEmptyRef();
        }
        WeakReference<ReentrantLock> lockRef = lockMap.get(key);
        ReentrantLock lock = (lockRef == null ? null : lockRef.get());
        while (lock == null) {
            lockMap.putIfAbsent(key, new WeakLockRef<>(new ReentrantLock(), queue, key));
            lockRef = lockMap.get(key);
            lock = (lockRef == null ? null : lockRef.get());
            if (lock != null) {
                return lock;
            }
            clearEmptyRef();
        }
        return lock;
    }

    @SuppressWarnings("unchecked")
    private void clearEmptyRef() {
        Reference<? extends ReentrantLock> ref;
        while ((ref = queue.poll()) != null) {
            WeakLockRef<T, ? extends ReentrantLock> weakLockRef = (WeakLockRef<T, ? extends ReentrantLock>) ref;
            lockMap.remove(weakLockRef.key);
        }
    }

    private static final class WeakLockRef<T, K> extends WeakReference<K> {
        final T key;

        private WeakLockRef(K referent, ReferenceQueue<? super K> q, T key) {
            super(referent, q);
            this.key = key;
        }
    }
}
