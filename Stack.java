public class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push (char data){
        Node baru = new Node (data);
        
        baru.next = top;
        top = baru;
    }

    public char pop() {
        if (isEmpty()) {
            return '\0';
        }

        char data = top.data;
        top = top.next;

        return data;
    }

    public char peek() {
        if (isEmpty()){
            return '\0';
        }

        return top.data;
    }
}
