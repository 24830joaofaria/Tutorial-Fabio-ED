package org.example;

import org.example.Exceptions.EmptyCollectionException;
import org.example.Implementations.LinkedQueue;
import org.example.Implementations.LinkedStack;
import org.example.Interfaces.QueueADT;
import org.example.Interfaces.StackADT;

public class Main {
    public static void main(String[] args) {

//        StackADT<String> stack = new LinkedStack();
//
//        stack.push("A");
//        System.out.println(stack.peek());
//        stack.push("B");
//        stack.push("C");
//        stack.push("D");
//        System.out.println(stack.toString());
//        //alteracao
//        stack.pop();
//        System.out.println(stack.peek());
        // PKFJASOFSJAPOFA


        try{
            QueueADT<String> queue = new LinkedQueue();
            System.out.println(queue.isEmpty());
            queue.enqueue("Johny");
            System.out.println(queue.first());
            queue.dequeue();
            System.out.println(queue.first());

        }catch(EmptyCollectionException e){
            System.out.println(e.getMessage());
        }

    }



}