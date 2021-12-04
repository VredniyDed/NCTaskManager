package ua.edu.sumdu.j2se.moroz.tasks;

abstract class AbstractTaskList  implements Cloneable, Iterable<Task>{
    public abstract int size();
    public abstract void add(Task task);
    public abstract Task getTask(int index);
    public abstract boolean remove(Task task);
    protected ListTypes.types type;
    protected int size;
    public AbstractTaskList incoming(int from, int to){
        if (from<0){
            throw new IllegalArgumentException("from < 0");
        }
        if (to < 0){
            throw new IllegalArgumentException("to < 0");
        }
        if (from >= to){
            throw new IllegalArgumentException("from >= tp");
        }
        AbstractTaskList arr = TaskListFactory.createTaskList(type) ;
        for (int i = 0; i<size; i++){
            if (getTask(i) != null && getTask(i).nextTimeAfter(from) != -1 && getTask(i).nextTimeAfter(from) < to){
                arr.add(getTask(i));
            }
        }
        return arr;
    }

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
