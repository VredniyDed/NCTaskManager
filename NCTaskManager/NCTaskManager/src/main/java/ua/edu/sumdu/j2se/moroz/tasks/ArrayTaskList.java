package ua.edu.sumdu.j2se.moroz.tasks;

public class ArrayTaskList {
    private Task[] array = new Task[10];
    private int size = 0;

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
            if (index<0 || index > size) {
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
            if (array[i].nextTimeAfter(from)!= -1 && array[i].nextTimeAfter(from)<=to){
                arr.add(array[i]);
            }
        }
        return arr;
    }
}

