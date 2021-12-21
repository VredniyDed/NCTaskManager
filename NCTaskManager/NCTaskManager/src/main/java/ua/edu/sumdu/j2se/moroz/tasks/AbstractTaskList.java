package ua.edu.sumdu.j2se.moroz.tasks;

import java.util.stream.Stream;

abstract class AbstractTaskList  implements Cloneable, Iterable<Task>{
    public abstract int size();
    public abstract void add(Task task);
    public abstract Task getTask(int index);
    public abstract boolean remove(Task task);
    protected ListTypes.types type;
    protected int size;
//    public final AbstractTaskList incoming(int from, int to){
//        if (from<0){
//            throw new IllegalArgumentException("from < 0");
//        }
//        if (to < 0){
//            throw new IllegalArgumentException("to < 0");
//        }
//        if (from >= to){
//            throw new IllegalArgumentException("from >= tp");
//        }
//        AbstractTaskList arr = TaskListFactory.createTaskList(type) ;
//
//        this.getStream().filter(t -> t != null && t.nextTimeAfter(from) != -1 && t.nextTimeAfter(from) < to).forEach(arr :: add);
//        return arr;
//    }

    public abstract Stream<Task> getStream();
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
