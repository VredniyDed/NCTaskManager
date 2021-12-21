package ua.edu.sumdu.j2se.moroz.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Tasks {

    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        if (tasks == null)
            throw new NullPointerException();
        if (start == null || end == null)
            throw new NullPointerException();
        if (start.isAfter(end) || start.equals(end))
            throw new IllegalArgumentException();

        List<Task> list = new LinkedList<Task>();
        LocalDateTime temp;
        for (Task t : tasks){
            temp = t.nextTimeAfter(start);
            if (temp != null && !temp.isAfter(end)) {
                list.add(t);
            }
        }
       return  list;
   }

     static public SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {
        TreeMap<LocalDateTime,Set<Task>> cr = new TreeMap<>();
        LocalDateTime temp;
        Set<Task> arr;
        tasks = incoming(tasks, start, end);
        for (Task t : tasks){
            temp = start;
            while (true){
                temp = t.nextTimeAfter(temp);
                if (temp == null || temp.isAfter(end))
                    break;
                if (cr.containsKey(temp)){
                    arr = cr.get(temp);
                }
                else{
                    arr = new HashSet<>();
                    cr.put(temp,arr);
                }
                arr.add(t);
            }
        }
        return  cr;
    }

}
