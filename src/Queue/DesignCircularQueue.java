package Queue;

class MyCircularQueue {

    private int[] arr;

    private int front;
    private int rear;

    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        arr = new int[k];

        size = 0;
        capacity = k;

        front = 0;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);

        int param1 = obj.Rear();
        System.out.println("Rear: " + param1);
        obj.isFull();

        obj.deQueue();
        obj.enQueue(4);

        int param2 = obj.Front();
        System.out.println("Front: " + param2);
        obj.isEmpty();
    }
}


