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
        // PKFJASOFSJAPOFAa


        // Criação de uma pilha de inteiros
        StackADT<Integer> stack = new LinkedStack<>();

        // Verificar se a pilha está vazia e o tamanho inicial
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
        System.out.println("Stack size: " + stack.size());        // 0

        // Adicionar elementos na pilha (push)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Exibir o estado da pilha após adicionar elementos
        System.out.println(stack);  // Stack: 30, 20, 10
        System.out.println("Stack size: " + stack.size());        // 3

        try {
            // Verificar o elemento no topo (peek)
            System.out.println("Peek: " + stack.peek());  // 30

            // Remover o elemento do topo (pop)
            System.out.println("Pop: " + stack.pop());    // 30
            System.out.println("Stack after pop: " + stack);  // Stack: 20, 10

            // Continuar removendo elementos
            System.out.println("Pop: " + stack.pop());    // 20
            System.out.println("Stack after pop: " + stack);  // Stack: 10
            System.out.println("Pop: " + stack.pop());    // 10
            System.out.println("Stack after pop: " + stack);  // Stack is empty.

            // Tentar remover de uma pilha vazia (lança EmptyCollectionException)
            System.out.println("Pop: " + stack.pop());
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());  // Stack is empty
        }

        // Verificar se a pilha está vazia
        System.out.println("Is stack empty? " + stack.isEmpty()); // true

        // Testar a expansão de capacidade
        LinkedStack<Integer> largeStack = new LinkedStack<>(); // Capacidade inicial pequena para testar expansão
        largeStack.push(1);
        largeStack.push(2);
        System.out.println("Stack before expansion: " + largeStack); // Stack: 2, 1

        largeStack.push(3); // Força expansão
        System.out.println("Stack after expansion: " + largeStack);  // Stack: 3, 2, 1
    }
}