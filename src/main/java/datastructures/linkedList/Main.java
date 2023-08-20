package datastructures.linkedList;

public class Main {
    public static void main(String[] args){
        System.out.println("<------Linked List------>");

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.printHead();
        linkedList.printTail();
        linkedList.printList();
        System.out.println("Get: "+linkedList.get(2).value);
        linkedList.insert(1,5);
        linkedList.set(1,6);
        linkedList.printList();
        System.out.println("Length: "+linkedList.length);
        linkedList.printList();
        linkedList.removeLast();
        System.out.println("----------");
        linkedList.printHead();
        linkedList.printTail();
        linkedList.printList();
        System.out.println("----------");
        linkedList.prepend(4);
        linkedList.remove(2);
        linkedList.printHead();
        linkedList.printTail();
        linkedList.printList();
//        linkedList.prepend(1);
        linkedList.removeFirst();
//        System.out.println(linkedList.removeFirst().value);
//        System.out.println(linkedList.removeFirst());
        linkedList.printHead();
        linkedList.printTail();
        linkedList.printList();
        linkedList.append(3);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.reverse();
        linkedList.printHead();
        linkedList.printTail();
        linkedList.printList();
//        System.out.println(linkedList.findKthFromEnd(3).value);
        linkedList.partitionList(3);
        linkedList.removeDuplicates();
//        linkedList.reverseBetween(1,3);
        linkedList.printList();


        System.out.println("<------Doubly Linked List------>");

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
        doublyLinkedList.getHead();
        doublyLinkedList.getTail();
        doublyLinkedList.printList();

        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.removeLast();
        doublyLinkedList.printList();

        doublyLinkedList.prepend(5);
        doublyLinkedList.append(4);
        doublyLinkedList.printList();

        doublyLinkedList.removeFirst();
        doublyLinkedList.printList();

//        System.out.println("---"+doublyLinkedList.get(2).val);
        doublyLinkedList.set(1,3);
        doublyLinkedList.insert(1,5);
        doublyLinkedList.printList();

        doublyLinkedList.remove(2);
        doublyLinkedList.printList();

        doublyLinkedList.swapFirstLast();
        doublyLinkedList.printList();










    }
}
