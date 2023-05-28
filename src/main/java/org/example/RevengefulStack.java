package org.example;
import java.util.LinkedList;
public class RevengefulStack<T> {
    private LinkedList<T> stack;
    private int capacity;
    public RevengefulStack(int initialCapacity) {
        stack = new LinkedList<>();
        capacity = initialCapacity;
    }

    public void push(T item) {
        int temp = capacity;
        if (stack.size() >= capacity/2) {
            if (temp == stack.size()) {
                throw new RuntimeException("I will no longer bow down to you!");
            }
            throw new RuntimeException("No. I won't let you.");
        }
        capacity /= 2;
        stack.push(item);
    }

    public T pop() {
        capacity /= 2;
        if (stack.isEmpty()) {
            throw new RuntimeException("I have nothing to give you.");
        }
        return stack.pop();
    }

    public int getSize() {
        return stack.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void printStack() {
        if (capacity <= stack.size()) {
            return;
        }

        capacity /= 2;

        for (T item : stack) {
            System.out.print(item + " ");
        }
    }


    public static void main(String[] args) {
        RevengefulStack<Integer> stack = new RevengefulStack<>(30);
        System.out.println("Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());

        try {
            stack.push(1);
            System.out.println("Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            stack.push(2);
            System.out.println("Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        try {
            stack.pop();
            System.out.println("Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            stack.push(3);
            System.out.println("Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("** print result **");
        stack.printStack();
        System.out.println("\n"+"Capacity = " + stack.getCapacity() + ", Size = " + stack.getSize());
    }
}
