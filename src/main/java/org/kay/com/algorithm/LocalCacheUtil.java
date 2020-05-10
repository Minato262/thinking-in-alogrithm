package org.kay.com.algorithm;

import com.alibaba.fastjson.JSONObject;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class LocalCacheUtil {

    private static Logger LOG = LoggerFactory.getLogger(LocalCacheUtil.class);

    private static final CacheManager cacheManager = CacheManager.create();

    private static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes(StandardCharsets.UTF_8));

            final char[] HEX_DIGITS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            StringBuilder ret = new StringBuilder(bytes.length);
            for (byte aByte : bytes) {
                ret.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
                //ret.append(HEX_DIGITS[aByte & 0x0f]);
            }
            return ret.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Cache getCacheInstance() {
        String cacheKey = "local_cache_" + md5(Thread.currentThread().getStackTrace()[1].getClassName());
        if (!cacheManager.cacheExists(cacheKey)) {
            synchronized (cacheManager) {
                if (!cacheManager.cacheExists(cacheKey)) {
                    CacheConfiguration cacheConfiguration = new CacheConfiguration();
                    cacheConfiguration.setTimeToIdleSeconds(60);
                    cacheConfiguration.setTimeToLiveSeconds(60);
                    cacheConfiguration.setName(cacheKey);
                    cacheConfiguration.setMaxEntriesLocalHeap(1);
                    cacheConfiguration.setMaxEntriesLocalDisk(100000);
                    cacheConfiguration.setEternal(false);
                    cacheConfiguration.setOverflowToDisk(true);
                    cacheConfiguration.setMaxElementsInMemory(1);
                    cacheConfiguration.setCopyOnRead(true);
                    cacheConfiguration.setCopyOnWrite(true);

                    Cache cache = new Cache(cacheConfiguration);
                    cacheManager.addCache(cache);
                }
            }
        }
        return cacheManager.getCache(cacheKey);
    }

    private static Element serialization(String key, Object value, Integer expireTime) {
        if (StringUtils.isEmpty(key) || null == expireTime || 0 == expireTime) {
            return null;
        }

        String content = "";
        if (null == value) {
            String clazz = "null";
            content = clazz + "_class&data_null";
        }
        else {
            String clazz = value.getClass().getName();
            content = clazz + "_class&data_" + JSONObject.toJSONString(value);
        }
        return new Element(key, content, expireTime, expireTime);
    }

    private static Object unSerialization(Element element) {
        if (null == element) {
            return null;
        }

        String content = (String) element.getObjectValue();
        String[] data = content.split("_class&data_");
        Object response = null;
        try {
            if ("null".equalsIgnoreCase(data[0])) {
                return null;
            }
            response = JSONObject.parseObject(data[1], Class.forName(data[0]));
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 设置本地缓存
     */
    public static boolean setCache(String key, Object value, Integer expireTime) {
        Cache cache = getCacheInstance();
        if (null == cache) {
            LOG.info("setCache:cache is null, {}, {}, {}", key, value, expireTime);
            return false;
        }
        if (StringUtils.isEmpty(key) || null == expireTime || 0 == expireTime) {
            LOG.info("setCache:params is not ok, {}, {}, {}", key, value, expireTime);
            return false;
        }

        synchronized (cache) {
            cache.put(serialization(key, value, expireTime));
            cache.flush();
        }
        return true;
    }

    /**
     * 获取本地缓存
     */
    public static Object getCache(String key) {
        Cache cache = getCacheInstance();
        if (null == cache || StringUtils.isEmpty(key)) {
            LOG.info("getCache:params is not ok, {}", key);
            return null;
        }

        Element element = cache.get(key);
        return unSerialization(element);
    }

    /**
     * 清理本地缓存
     */
    public static boolean delCache(String key) {
        Cache cache = getCacheInstance();
        if (null == cache) {
            LOG.info("delCache:cache is null, {}", key);
            return true;
        }
        if (StringUtils.isEmpty(key)) {
            LOG.info("delCache:params is not ok, {}", key);
            return true;
        }

        synchronized (cache) {
            cache.put(serialization(key, null, 0));
            cache.flush();
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        String md5 = md5("123");
        System.out.println(md5);

        md5 = md5("2011-01-21 01:12:11");
        System.out.println(md5);

        md5 = md5("2011-01-21 01:12:11");
        System.out.println(md5);

        final String request = "123";
        setCache("1", request, 1);

        Thread.sleep(600);
        Object object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);

        Thread.sleep(600);
        object = getCache("1");
        System.out.println(object);
    }
}
