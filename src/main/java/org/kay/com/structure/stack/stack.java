package org.kay.com.structure.stack;

/**
 * Stack.
 *
 * @author kay
 * @version v0.0.1
 */
public interface stack {

    void push(int data);

    int pop();

    int top();

    int size();

    int isEmpty();

    int isStatckFull();
}
