package LinkedListPractice;

public class LinkedListClient {
    public static void main(String[] args) throws Exception {
        LinkedList ll = new LinkedList();
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(5);
        ll.display();
        System.out.println();
        System.out.println(ll.getSize());

        //testing the reverse methods
        ll.dataReverseIterative();
        ll.display();
        ll.pointerReverseIterative();
        ll.display();
    }
}
