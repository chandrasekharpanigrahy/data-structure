package com.example.stream.api.service.datastructure;

// FIFO
public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue(int size) {
        this.data = (X[]) new Object[size];
        front = -1;
        end = -1;
    }

    public BasicQueue() {
        this(1000);
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {
        if (size() == 0) {
            front++;
            end++;
        } else {
            end++;
        }
        data[end] = item;

    }

    public X deQueue() {
        X item = null;
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        } else if (front == end) {
            item = data[front];
            // reset the queue to empty
            data[front] = null;
            end = -1;
            front = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item){
        boolean found = false;
        if(size() == 0){
            return found;
        }
        for(int i = front; i< end; i++){
            if(data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }
    public X access(int position) {
        if(size()==0 || size()<position){
            throw new IllegalArgumentException("Queue is empty or no element in the position");
        }
        int actualIndex = 0;
        X item = null;
        for(int i = front; i< end; i++){
            if(actualIndex == position){
                item = data[i];
                break;
            }
            actualIndex++;
        }
        return item;
    }
}
