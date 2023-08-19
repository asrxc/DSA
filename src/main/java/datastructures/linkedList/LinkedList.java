package datastructures.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    LinkedList(int val){
        Node newNode = new Node(val);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printHead(){
        System.out.println("Head: "+head.value);
    }

    public void printTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void printLength(){
        System.out.println("Length: "+length);
    }

    public void printList(){
        Node temp = head;
        System.out.println("----------");
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int val){
        Node newNode = new Node(val);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        if(tail.next == null){
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        pre.next=null;
        tail = pre;
        length--;
        if(length == 0){
            head=null;
            tail=null;
        }
        return temp;
    }



    public void prepend(int val){
    Node newNode  = new Node(val);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    length++;
    }

    public Node removeFirst(){
        if(length == 0){
          return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail=null;
        }
        return temp;
    }

    public Node get(int idx){
        if(idx < 0 || idx >= length ){
            return null;
        }
        Node temp=head;
        for(int i=0; i < idx; i++){
            temp=temp.next;
        }
        return temp;
    }

    public boolean insert(int idx, int value){
        if(idx < 0 || idx > length ){
            return false;
        }

        if(idx == 0){
            prepend(value);
            return true;
        }
        if(idx == length){
            append(value);
            return true;
        }

        Node pre = head;
        Node temp = head;
        Node newNode = new Node(value);
        for(int i=0;i<idx;i++){
            pre=temp;
            temp=temp.next;
        }
        pre.next = newNode;
        newNode.next = temp;
        length++;

        return true;
    }
    public boolean set(int idx, int value){
        Node temp = get(idx);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public Node remove(int idx){
        if(idx < 0 || idx > length ){
            return null;
        }
        if(idx == 0){
            removeFirst();
        }
        if(idx == length-1){
            removeLast();
        }
        Node temp = get(idx);
        Node pre = get(idx-1);
        pre.next= temp.next;
        temp.next = null;
        length--;
        return temp;
    }



    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;
        int i=0;
        while(i<k){
            if(fast == null){
                return null;
            }
            fast = fast.next;
            i++;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        while(temp!=null){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }
    public void reverseBetween(int m, int n) {
        if(head == null){
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for(int i=0;i<m;i++){
            prev=prev.next;
        }
        Node current = prev.next;
        for(int i=0;i<n-m;i++){
            Node temp=current.next;
            current.next = temp.next;
            temp.next=prev.next;
            prev.next=temp;
        }

        head=dummy.next;

    }

    public void partitionList(int x) {
        if(head == null){return;}
        Node dummy1 = new Node(0);
        Node prev1 = dummy1;
        Node dummy2 = new Node(0);
        Node prev2 = dummy2;
        Node current = head;

        while(current != null){
            if( current.value < x){
                prev1.next = current;
                prev1 = current;
            }else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next=null;
        prev1.next = dummy2.next;
        head=dummy1.next ;
    }


    public void removeDuplicates(){
        Node current = head;
        Node prev =  null;

        HashSet<Integer> set = new HashSet<>();

        while(current != null){
            if(set.contains(current.value)){
                prev.next= current.next;
                length--;
            }else{
                set.add(current.value);
                prev=current;
            }
            current = current.next;
        }
    }

}
