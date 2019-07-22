package com.aniket;


public class Queue<E> {
    private E queue[];
    public int defaultCapacity = 8;
    private int size, rear,front,capacity;

    //default queue of size 10
    public Queue(){
        queue = (E[]) new Object[defaultCapacity];
        this.capacity = defaultCapacity;
        this.front = 0;
        this.rear = 0;
    }
    //parameterized constructor for supplied capacity
    public Queue(int length){
        this.queue = (E[])new Object[capacity];
        this.capacity = length;
        this.front = 0;
        this.rear = 0;

    }

    public void add(E item) throws RuntimeException{
        //only add if space is available
        if(isFull()){
            throw new RuntimeException("Circular Queue is full");
        }else{
            this.queue[this.rear] = item;
            this.rear = (this.rear + 1) % this.capacity;
            this.size++; // increase number of elements in Circular queue
        }
    }

    public E remove() throws RuntimeException {
        E deQueuedElement;
        if(isEmpty()){
            throw new RuntimeException("Circular Queue is empty");
        }
        else{
            deQueuedElement = queue[this.front];
            this.queue[this.front] = null;
            this.front = (this.front + 1) % this.capacity;
            this.size--; // Reduce number of elements from Circular queue
        }
        return deQueuedElement;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int capacity(){
        return this.capacity;
    }


}
