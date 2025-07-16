public class Queue {
    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    Queue(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head==null && tail==null;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            tail = head = newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    
    public int remove(){
        if(isEmpty()){
            return -1;
        }

        int front = head.data;

        if(head==tail){
            tail=null;
        }

        head=head.next;
        return front;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}
