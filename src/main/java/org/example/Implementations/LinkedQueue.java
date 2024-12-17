package org.example.Implementations;

import org.example.Exceptions.EmptyCollectionException;
import org.example.Interfaces.QueueADT;
import org.example.Interfaces.StackADT;

public class LinkedQueue<T>   implements QueueADT<T> {

    private LinearNode<T> front; //variavel que aponta para o topo // unica visivel
    private LinearNode<T> rear;  //variavel que aponta para o cu
    private int size;

    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = front.getElement();
        front = front.getNext();

        if(isEmpty()){
            front = null;
            rear = null;
        }
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}