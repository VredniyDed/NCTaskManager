package ua.edu.sumdu.j2se.moroz.tasks;

import java.util.*;

public class ArrayTaskList extends AbstractTaskList {
    private Task[] array = new Task[10];
    private ListTypes.types type = ListTypes.types.ARRAY;
    public ArrayTaskList() {
        type = ListTypes.types.ARRAY;
         size = 0;

    }
    public void add(Task task){
        if (size == array.length){
            Task [] temp = array;
            array = new Task[size+10];
            System.arraycopy(temp,0,array,0,size);
            array = temp;
        }
        array[size] = task;
        size++;
    }
    public int size() {
        return  size;
    }
    public Task getTask(int index){
            if (array == null){
                throw new NullPointerException("Array is empty");
            }
            if (index<0 || index >= size) {
                throw new IndexOutOfBoundsException("Out of range");
            }
        return array[index];
    }
    public boolean remove(Task task) {
        for (int i = 0;i < size; i++){
            if (array[i].equals(task)){
                for (int j = i+1; j<size; j++) {
                    array[i] = array[j];
                    i++;
                }
                size--;
                return  true;
            }
        }
        return false;
    }
    public ArrayTaskList incoming(int from, int to){
        if (from<0){
            throw new IllegalArgumentException("from < 0");
        }
        if (to < 0){
            throw new IllegalArgumentException("to < 0");
        }
        if (from >= to){
            throw new IllegalArgumentException("from >= tp");
        }
        ArrayTaskList arr = new ArrayTaskList();
        for (int i = 0; i<size; i++){
            if (array[i] != null && array[i].nextTimeAfter(from)!= -1 && array[i].nextTimeAfter(from) < to){
                arr.add(array[i]);
            }
        }
        return arr;
    }

    @Override
    public Iterator<Task> iterator() {
        return new ArrayIterator(this);
    }

    static class ArrayIterator implements  Iterator<Task>{
        private int itr = 0;
        private ArrayTaskList arrayItr;
        private Task t;
        public ArrayIterator(ArrayTaskList arrayTaskList){
            this.arrayItr = arrayTaskList;
        }

        @Override
        public boolean hasNext() {
            return itr < arrayItr.size();
        }

        @Override
        public Task next() throws  NoSuchElementException{
            if (!hasNext()) throw new NoSuchElementException("List doesn't have a next element");
            t = arrayItr.getTask(itr++);
            return t;
        }

        @Override
        public void remove() throws  IllegalStateException{
            if (t == null) throw new IllegalStateException("Can't remove without next");
            arrayItr.remove(t);
            itr--;
        }
    }

    @Override
    public ArrayTaskList clone() throws CloneNotSupportedException {
        ArrayTaskList cl = new ArrayTaskList();
        for (int i = 0; i < size; i++) {
            cl.array[i] = array[i];
        }
        cl.size = size;
        cl.type = type;
        return cl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type,size);
    }

    @Override
    public boolean equals(Object obj) {
        ArrayTaskList arr = (ArrayTaskList) obj;
        if (this == obj) return true;
        if ( obj == null || getClass() != obj.getClass()) return false;
        for (int i = 0; i< size; i++) {
            if (!arr.array[i].equals(array[i])){
                return  false;
            }
        }
        return type == arr.type && size == arr.size ;
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "type=" + type +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                ", type=" + type +
                '}';
    }
}

