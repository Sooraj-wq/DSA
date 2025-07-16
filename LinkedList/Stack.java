public class Stack{

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head;
    
    public Stack(){
        this.head = null;
    }
  
    public boolean isEmpty(){
        return head==null;
    }
  
    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public int pop(){
        
        if(isEmpty()){
            return -1;
        }
        int top = head.data;
        head=head.next;
        return top;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }

    public static void main (String args[]){
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.pop());
        System.out.println(stack1.peek());


    }
}