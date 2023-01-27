package pkg20221102;

import java.util.Stack;

public class stack_test 
{
    public static void main(String[] args) 
    {
        Node test = new Node(5);
        test.prev=test;
        test.next =new Node(10);
        test.next.prev = test;
        test.next.next = new Node (15);
        test.next.next.prev = test.next;
        test.next.next.next = new Node (20);
        test.next.next.next.prev = test.next.next;
    }
    
}