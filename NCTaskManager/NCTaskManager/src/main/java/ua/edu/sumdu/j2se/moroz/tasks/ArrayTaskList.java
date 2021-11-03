package ua.edu.sumdu.j2se.moroz.tasks;

public class ArrayTaskList {
    private Task[] array;
    private int size ;

    public void add(Task task){
        if (size == 0) {
            array = new Task[++size];
        }
        else {
            Task [] temp = array;
            array = new Task[++size];
            System.arraycopy(temp,0,array,0,size-1);
        }
        array[size-1] = task;
    }

    public int size() {
        return  size;
    }
   public Task getTask(int index){
        return array[index];
    }
    public boolean remove(Task task) {
        for (int i = 0;i < size; i++){
            if (array[i].equals(task)){
                if (size == 1){
                    --size;
                    array = null;
                }
                else {
                    Task [] temp = array;
                    array = new Task [--size];
                    System.arraycopy(temp,0,array,0,i);
                    System.arraycopy(temp,i+1,array,i,size-i);
                }
                return  true;
            }
        }
        return false;
    }

    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList arr = new ArrayTaskList();
        for (int i = 0; i<size; i++){
            if (array[i].nextTimeAfter(from)!= -1 && array[i].nextTimeAfter(from)<=to){
                arr.add(array[i]);
            }
        }
        return arr;
    }
}

