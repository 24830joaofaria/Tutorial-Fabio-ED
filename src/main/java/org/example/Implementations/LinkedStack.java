package org.example.Implementations;

import org.example.Exceptions.EmptyCollectionException;
import org.example.Interfaces.StackADT;

public class LinkedStack<T> implements StackADT<T> {

    private LinearNode<T> top; // variavel que aponta para o topo // unica visivel
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if(isEmpty()){
            top = newNode;
        }else{
            newNode.setNext(top);
            top  = newNode;
        }

        size++;
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if(isEmpty()){
            throw new EmptyCollectionException("stack");
        }

        T result = top.getElement();
        top = top.getNext();

        size--;
        return result;
    }

    @Override
    public T peek()throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("stack");
        }
        return this.top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

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
