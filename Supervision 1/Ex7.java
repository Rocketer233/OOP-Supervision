public class Element{
    int val;
    Element next;

    Element(int x){
        val = x;
        next = null;
    }
}

public class SinglyLinkedList {
    int length;
    Element head, tail;

    SinglyLinkedList(){
        length = 0;
        head = tail = null;
    }

    void Add(int x){
        Element node = new Element (x);
        if (head == null)
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    void Remove(){
        head = head.next;
        length--;
    }

    int QueryHead(){
        return head.val;
    }

    int nth(int n, Element now){
        if(n == 1)
            return now.val;
        return nth(n - 1, now.next);
    }

    int nth(int n){
        return nth(n, head);
    }

    int QueryLength(){
        return length;
    }
}
