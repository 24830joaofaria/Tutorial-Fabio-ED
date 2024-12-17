package org.example.Implementations;

import org.example.Exceptions.EmptyCollectionException;
import org.example.Interfaces.StackADT;

/**
 * Implements a stack using a linked list.
 *
 * @param <T> the type of elements in this stack
 */
public class LinkedStack<T> implements StackADT<T> {

    // The top node of the stack
    private LinearNode<T> top;

    // Number of elements in the stack
    private int size;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Adds the specified element to the top of this stack.
     * If the stack is currently empty, the new element becomes
     * the top of the stack. If the stack is not empty, the new
     * element is linked to the current top and becomes the new top.
     *
     * @param element the generic element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        // Create a new node with the element
        LinearNode<T> newNode = new LinearNode<>(element);

        // If the stack is empty, the new node becomes the top
        if (isEmpty()) {
            top = newNode;
        } else {
            // Otherwise, link the new node to the current top and update the top
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the top of this stack and
     * returns a reference to it.
     * Throws an EmptyCollectionException if the stack is empty.
     * @return T element removed from the top of the stack
     * @throws EmptyCollectionException if a pop
     * is attempted on an empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        T result = top.getElement();
        top = top.getNext();
        size--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element on top of the stack
     * @throws EmptyCollectionException if a peek
     * is attempted on an empty stack
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return top.getElement();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return boolean true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return int the number of elements in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this stack.
     * The string represents the elements from top to bottom.
     * @return String representation of the stack
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty.";
        }

        StringBuilder result = new StringBuilder("Stack: ");
        LinearNode<T> current = top;

        // Iterate from top to bottom of the stack
        while (current != null) {
            result.append(current.getElement());
            current = current.getNext();

            if (current != null) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
