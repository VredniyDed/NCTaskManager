package ua.edu.sumdu.j2se.moroz.tasks;

public class TaskListFactory {
    public static AbstractTaskList createTaskList(ListTypes.types type){
        AbstractTaskList objectType = null;
        switch (type){
            case ARRAY:
                objectType = new  ArrayTaskList(); break;
            case LINKED:
                objectType = new  LinkedTaskList(); break;
        }
        return objectType;
    }
}
