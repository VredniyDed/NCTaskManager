package ua.edu.sumdu.j2se.moroz.tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList  {

    public static class Node {
        public Task data;
        public Node next;

        public Node(Task data) {
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
    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException("List is empty");
        }
        Node temp = new Node(task);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }
    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        if (index == 0) {
            return head.data;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }
    public boolean remove(Task task) {
        if (task == null) {
            throw new NullPointerException("remoted task is null");
        }
        Node cur = head;
        Node prev = head;
        if (size == 0) {
            return false;
        } else {
            while (!cur.data.equals(task)) {
                prev = cur;
                cur = cur.next;
            }
            if (cur != null) {
                if (cur == head) {
                    head = head.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return true;
           }
        }
        return false;
    }
    public int size() {
        return size;
    }

    @Override
    public Iterator<Task> iterator() {
        return new LinkedIterator(this);
    }
    static class LinkedIterator implements  Iterator<Task>{
        private final LinkedTaskList linkedItr;
        private int itr = 0;
        private Task t;
        public LinkedIterator(LinkedTaskList arrayTaskList){
            this.linkedItr = arrayTaskList;
        }

        @Override
        public boolean hasNext() {
            return itr < linkedItr.size();
        }

        @Override
        public Task next() throws NoSuchElementException {
            if(hasNext()){
                t = linkedItr.getTask(itr++);
                return t;
            }
            else throw new NoSuchElementException("List doesn't have a next element");
        }

        @Override
        public void remove() throws  IllegalStateException{
            if (t == null) throw new IllegalStateException("Can't remove() without next()");
            linkedItr.remove(t);
            itr--;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        if (that.head == null && head == null) return true;
        while (head.next != null) {
            if (!(that.head.data.equals(head.data))) {
                return false;
            }
            head = head.next;
        }
        return head.data.equals(that.head.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, head.data.getTitle());
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "type=" + type +
                ", size=" + size +
                ", head=" + head.data +
                '}';
    }

    @Override
    public Stream<Task> getStream() {
        Stream.Builder<Task> builder = Stream.builder();
        for (int i = 0; i < size; i++){
            builder.add(getTask(i));
        }
        return builder.build();
    }
}
