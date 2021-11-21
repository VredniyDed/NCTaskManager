package ua.edu.sumdu.j2se.moroz.tasks;

public class LinkedTaskList extends AbstractTaskList {

    public class Node {
        public Task data;
        public Node next;
        public Node(Task data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    public LinkedTaskList() {
        head = null;
        type = ListTypes.types.LINKED;
        size = 0;
    }
    public void add(Task task){
        if (task == null){
            throw new NullPointerException("List is empty");
        }
        Node temp = new Node(task);
        if (head == null) {
            head = temp;
        }
        else {
            temp.next = head;
            head = temp;
        }
        size++;
    }
    public Task getTask(int index){
        if (index<0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        if (index == 0) {
            return head.data;
        }
        else {
            Node temp = head;
            for (int i = 0; i<index; i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }
    public boolean remove(Task task){
        if (task == null){
            throw  new NullPointerException("remoted task is null");
        }
        Node cur = head;
        Node prev = head;
        if (size == 0){
            return false;
        }
        else {
            while (!cur.data.equals(task) && cur != null){
                prev = cur;
                cur = cur.next;
            }
            if (cur != null){
                if (cur == head){
                    head = head.next;
                }
                else {
                    prev.next = cur.next;
                }
                size--;
                return true;
            }
        }
       return false;
    }

     public int size (){
       return size;
     }

    public LinkedTaskList incoming(int from, int to){
        if (from<0){
            throw new IllegalArgumentException("from < 0");
        }
        if (to < 0){
            throw new IllegalArgumentException("to < 0");
        }
        if (from >= to){
            throw new IllegalArgumentException("from >= tp");
        }
        LinkedTaskList list = new LinkedTaskList();
        Node temp = head;
        for (int i = 0; i<size; i++){
            if (temp != null && temp.data.nextTimeAfter(from)!= -1 && temp.data.nextTimeAfter(from) < to){
                list.add(temp.data);
            }
            temp = temp.next;
        }
        return list;
    }
}
