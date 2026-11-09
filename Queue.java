public class Queue {

    private String[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        data = new String[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(String expression) {

        if (isFull()) {
            System.out.println("Antrean penuh!");
            return;
        }

        rear = (rear + 1) % capacity;
        data[rear] = expression;
        size++;

        System.out.println("Berhasil ditambahkan!");
    }

    public String dequeue() {

        if (isEmpty()) {
            return null;
        }

        String expression = data[front];

        data[front] = null;
        front = (front + 1) % capacity;
        size--;

        return expression;
    }

    public String peek() {

        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Antrean masih kosong!");
            return;
        }

        System.out.println("\n=== DAFTAR ANTREAN ===");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.println(
                (i + 1) + ". " + data[index]
            );
        }
    }

    public int getSize() {
        return size;
    }
}
