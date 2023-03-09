package com.asd.queuelab;

import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> queue;

    public Queue() {

        queue = new ArrayList<T>();

    }

    // adds element to tail of queue
    public void enqueue(T data) {

        queue.add(data);

    }

    // removes head of queue
    public boolean dequeue() {

        try {

            queue.remove(queue.size() - 1);

        } catch (IndexOutOfBoundsException e) {

            return false;

        }

        return true;

    }

    public int size() {

        if (queue != null) {

            return queue.size();

        }

        return -1;

    }

    // returns element at index
    public T get(int index) {

        try {

            return queue.get(index);

        } catch (ArrayIndexOutOfBoundsException e) {

            return null;

        }

    }

    public String toString() {

        String s = "{";

        for (T t : queue) {

            s += t + ", ";

        }

        return (s.substring(0, s.length() - 2) + "}");

    }

}