package org.example;

import org.example.Implementations.LinkedStack;
import org.example.Interfaces.StackADT;

public class Main {
    public static void main(String[] args) {

        StackADT<String> stack = new LinkedStack();

        stack.push("A");
        System.out.println(stack.peek());
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.toString());
        //alteracao
        stack.pop();
        System.out.println(stack.peek());


    }



}