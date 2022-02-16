package LinkedListPractice;

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


}
