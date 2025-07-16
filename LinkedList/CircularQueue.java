

public class CircularQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node tail;

    public CircularQueue() {
        tail = null; //Only tail reference is needed in circular queue.
    }

    public boolean isEmpty() {
      return tail == null;
    }

    public void add(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            tail = newNode;
            tail.next = tail; //Circular connection - points to itself
        }else{
            //Insert after tail
            newNode.next = tail.next;  //newNode points to head
            tail.next = newNode;  //old tail points to newNode
            tail = newNode;
        }
    }

    public int remove(){
        if(isEmpty()){
            return -1;
        }

        Node head = tail.next; //Head is always tail.next;
        int front = head.data;

        if(head==tail){
            tail = null; //In case there is only one node.
        }else{
            tail.next = head.next;
        }

        return front;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }

        return tail.next.data;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return;
        }
        Node current = tail.next;
        boolean first = true; //This is done to avoid a do-while loop and handle the first case.
        while(first || current!=tail.next){
            System.out.print(current.data + " ");
            current = current.next;
            first = false;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.print();
        
        System.out.println(queue.peek());
        
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.print();
        
    }
}
