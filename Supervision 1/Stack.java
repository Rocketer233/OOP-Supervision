public class Stack<T>{
    class Element{
        T val;
        Element next;

        Element(T x){
            val = x;
            next = null;
        }
    }

    Element head;

    Stack(){
        head = null;
    }

    void Push(T x){
        Element node = new Element(x);
        node.next = head;
        head = node;
    }

    void Pop(){
        head = head.next;
    }

    T top(){
        return head.val;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
    }
}
