package LinkedListPractice;

import java.util.concurrent.ExecutionException;

public class LinkedList {
    //making the node class
    public class Node{
        int data;
        Node next;

        //making the constructor
        public Node(int item){
            this.data = item;
        }

        //making the default constructor
        public Node(){

        }
    }

    //declaring some of the private variables
    private Node head;
    private Node tail;
    private int size;

    //making the adding node function
    public void addFirst(int item){
        //making the new node
        Node nn = new Node(item);

        if (this.size == 0){
            this.head = nn;
            this.tail = nn;
            this.size++;
        }
        else{
            nn.next = this.head;
            this.head = nn;
            this.size++;
        }
    }

    public void addLast(int item){
        Node nn = new Node(item);

        if (this.size == 0){
            //simple call the addFirst function as the order does not matter
            addFirst(item);
        }
        else{
            this.tail.next = nn;
            this.tail = nn;
            this.size++;
        }
    }

    //making the addAt function
    public void addAt(int item,int k) throws Exception{
        if (k==0){
            addFirst(item);
        }
        else if (k == this.size){
            addLast(item);
        }
        else{
            //creating the new node
            Node nn = new Node(item);
            //getting the node before k
            Node before = GetAt(k-1);
            nn.next = before.next;
            before.next = nn;
            this.size++;
        }
    }

    //making the GetNodeAt
    public Node GetAt(int k) throws Exception{
        if (k<=0 && k>=this.size){
            throw new Exception("Invalid index");
        }
        Node temp = this.head;
        for (int i = 1; i <=k ; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //making the display function
    public void display(){
        Node temp = this.head;

        while (temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(".");
    }

    //making the get functions
    public int getFirst() throws Exception{
        if (this.size == 0){
            throw new Exception("Linkedlist is empty");
        }
        return this.head.data;
    }

    //making the getLast function
    public int getLast() throws Exception{
        if (this.size == 0){
            throw new Exception("Linkedlist is empty");
        }
        return this.tail.data;
    }

    //making the Getat
    public int getAt(int k) throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is empty");
        }
        return this.GetAt(k).data;
    }

    //making the remove functions
    public int removeFirst() throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is empty");
        }
        int rv = this.head.data;

        if (this.size == 1){
            this.head = null;
            this.tail = null;
            this.size--;
        }
        else{
            Node temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            this.size--;
        }
        return rv;
    }

    //making the removeLast function
    public int removeLast() throws Exception{
        if (this.size == 0){
           throw new Exception("Linked list is empty");
        }

        //if there is only one node then call remove first
        if (this.size==1){
            return removeFirst();
        }
        else{
            //capturing the second last node
            Node sl = GetAt(this.size-1);
            int temp = sl.next.data;
            sl.next = null;
            this.tail = sl;
            this.size--;
            return temp;
        }

    }

    //making the removeAt function
    public int removeAt(int k) throws Exception{
        if (k<0 || k>=this.size){
            throw new Exception("Invalid index");
        }
        if (k==0){
            return this.removeFirst();
        }
        else if (k == this.size-1){
            return removeLast();
        }
        else{
            Node k_1 = GetAt(k-1); //before
            Node kth = GetAt(k);
            k_1.next = kth.next;
            kth.next = null;
            this.size--;
            return kth.data;
        }

    }



  


}
