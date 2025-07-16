//A program to implement Queue using 2 stacks

import java.util.*;
public class QueueUsingStack{
    public static class Queue{
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            
            public void add(int n){
                s1.push(n);
            }

            public int remove(){
                
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                
                //retrieve the top element of s2
                int front = s2.pop();
                
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                
                return front;
            }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
    }
}