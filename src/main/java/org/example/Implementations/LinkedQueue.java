package org.example.Implementations;

import org.example.Exceptions.EmptyCollectionException;
import org.example.Interfaces.QueueADT;
import org.example.Interfaces.StackADT;

public class LinkedQueue<T> implements QueueADT<T> {

    // The front node of the queue
    private LinearNode<T> front;

    // The rear node of queue
    private LinearNode<T> rear;

    // Number of elements in the queue
    private int size;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }


    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the queue
     */
    @Override
    public void enqueue(T element) {
        // Create a new node with the element
        LinearNode<T> newNode = new LinearNode<>(element);

        // If the queue is empty, the new node becomes the front and rear
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Otherwise, link the new node to the current rear and update the top
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to it.
     * Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        // If the queue is empty, throws an exception
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }

        T result = front.getElement();
        front = front.getNext();
        size--;

        // If the queue is now empty, set rear to null as well
        if (isEmpty()) {
            front = null;
            rear = null;
        }

        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.
     * Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }
        return front.getElement();
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this queue.
     * The string represents the elements from front to rear.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty.";
        }

        StringBuilder result = new StringBuilder("Queue: ");
        LinearNode<T> current = front;

        // Iterate through the queue from front to rear
        while (current != null) {
            result.append(current.getElement());
            current = current.getNext();
            if (current != null) {
                result.append(" <- ");
            }
        }

        return result.toString();
    }
}