
public class LinkedList {

    public class Node{

        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedList(){
        this.head = null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;

        while(currNode.next!=null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
        newNode.next = null;
    }

    public void removeFirst(){
        if(head==null){
            return;
        }
        head = head.next;
    }

    public void removeLast(){
        if(head==null || head.next==null){
            head = null; //Even if head.next = null, we want to remove the current node, hence this statement is essential
            return;
        }

        Node lastNode = head.next;
        Node prevNode = head;

        while(lastNode.next!=null){
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        prevNode.next = null;
    }

    public void reverse(){

        if(head == null || head.next == null){
            return;
        };
        Node currentNode = head.next;
        Node prevNode = head;
        while(currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null; // A very essential step to ensure that first element points to null before declaring the last node as the head!
        head = prevNode; //Avoids infinite loop
    }

    public Node reverserec(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverserec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public Node removeNthFromEnd(Node head, int n){
        if(head.next==null){
            return null;
        }
        int size=0;
        Node currNode = head;
        while(currNode!=null){
            currNode=currNode.next;
            size++;
        }
        if(n==size){
            return head.next;
        }

        int index = size - n;
        Node prevNode = head;
        int i = 1;
        while(i<index){
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }

    public boolean isPalindrome(Node head){
        if(head==null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverserec(slow);
        Node copySecondHalf = secondHalf;
        Node firstHalf = head;
        while(secondHalf!=null){
            if(firstHalf.data!=secondHalf.data){
                reverserec(copySecondHalf);
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        reverserec(copySecondHalf); //To restore the inplace reversal of the linked list. Essential step for further operations!!
        return true;
    }

    public void print(){
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        
        LinkedList LL = new LinkedList();

        LL.addFirst(2);
        LL.addFirst(3);
        LL.addLast(2);
        LL.addLast(3);
        System.out.println(LL.isPalindrome(LL.head));    
        //LL.removeFirst();
        //LL.removeLast();
        //LL.head = LL.reverserec(LL.head);
        LL.print();
    }


    
}
