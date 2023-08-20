package datastructures.linkedList;

public class DoublyLinkedList {
    int length;
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }

    public DoublyLinkedList(int val){
        Node newNode = new Node(val);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        System.out.println("---------------");
        System.out.println("Length: "+length);
        System.out.println("----------");
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head: "+head.value);
    }

    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void getLength(){
        System.out.println("Length: "+length);
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        Node temp = tail;
        if(length == 0){
            return null;
        }else if(length == 1){
            head = null;
            tail = null;
        }else{
            tail.prev.next = null;
            tail = tail.prev;
        }
        length--;
        return temp;
    }

    public void prepend (int val) {
        if(length == 0){
            append(val);
        }else {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            length++;
        }
    }

    public Node removeFirst(){
        Node current = head;
        if(length == 0){
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
            return current;
        } else{
            current.next.prev = null;
            head = current.next;
            current.next = null;
            length--;
            return current;
        }
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }else{
            Node temp = head;
            if(index < length/2){
                for (int i=0;i<index;i++){
                    temp = temp.next;
                }
            }else{
                temp = tail;
                for (int i=length-1;i>index;i--){
                    temp = temp.prev;
                }
            }
            return temp;
        }
    }

    public boolean set(int index, int value){
        Node node = get(index);
        if(node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node before = get(index -1);
            Node after = before.next;
            newNode.prev = before;
            newNode.next = after;
            before.next = newNode;
            after.prev = newNode;
            length++;
            return true;
        }
    }

    public Node remove(int index){
        if(index < 0 || index >=length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node current = get(index);
        Node previous = current.prev;
        Node next = current.next;

        previous.next = current.next;
        next.prev = previous;
        current.next = null;
        current.prev = null;
        length--;
        return current;
    }

    public void swapFirstLast(){
        if(length == 0){return;}
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }


}
