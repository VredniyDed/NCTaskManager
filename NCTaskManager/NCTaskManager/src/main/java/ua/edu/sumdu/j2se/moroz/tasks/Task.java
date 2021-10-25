package ua.edu.sumdu.j2se.moroz.tasks;
/**
 * The Task class implements the functionality
 * of the task manager with repetitive and non-repetitive tasks
 *
 * @author Valeria Moroz
 * @version 1.0
 */


public class Task {
    private String title;                            //task name
    private  int time;                               //task execution time
    private int start;                               //time when task starts
    private int end;                                 //time when task ends
    private int interval;                            //interval between task iterations
    private boolean active;                          //task activity status
    private boolean isRepeated;                      //task recurrence status

    /**
     * Constructor for a non-repeating task
     *
     * @param title - task name
     * @param time - task execution time
     */

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        isRepeated = false;
    }

    /**
     * Constructor for a repeating task
     *
     * @param title - task name
     * @param start - time when task starts
     * @param end - time when task ends
     * @param interval - interval between task iterations
     */

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        isRepeated = true;
    }

    /**
     * Method for setting a task name
     *
     * @param title - task name
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method for getting a task name
     *
     * @return String - task name
     */

    public String getTitle() {
        return title;
    }

    /**
     * Method for setting a task status
     *
     * @param active - task status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method for checking task status
     *
     * @return boolean - return true if task is active else false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Method for setting a time of a non-repeating task
     * If task is repeated change it
     *
     * @param time - task execution time
     */
    public void setTime(int time) {
        if (isRepeated) {
            isRepeated = false;
        }
        this.time = time;
    }

    /**
     * Method for getting a time of a non-repeating task
     * If task is repeated return start time
     *
     * @return int - task execution time
     */
    public int getTime() {
        if (isRepeated) {
            return start;
        }
        return time;
    }

    /**
     * Method for getting a start time of a repeating task
     * If task is non-repeated return  task execution time
     *
     * @return int - time when task starts for repeating task
     * or execution time for non-repeating task
     */
    public int getStartTime() {
        if (!isRepeated) {
            return time;
        }
        return start;
    }

    /**
     * Method for getting an end time of a repeating task
     * If task is non-repeated return  task execution time
     *
     * @return int - time when task ends for repeating task
     * or execution time for non-repeating task
     */
    public int getEndTime() {
        if (!isRepeated) {
            return time;
        }
        return end;
    }

    /**
     * Method for getting an interval between iterations of a repeating task
     * If task is non-repeated return  interval = 0
     *
     * @return int - interval between task iterations
     * or 0 for non-repeating task
     */

    public  int getRepeatInterval() {
        if (!isRepeated){
            return 0;
        }
        return interval;
    }

    /**
     * Method for setting a start time, end time, interval of a repeating task
     * If task is non-repeated change it
     *
     * @param start - time when task starts
     * @param end - time when task ends
     * @param interval - interval between task iterations
     */
    public void setTime (int start, int end, int interval){
        if (!isRepeated){
            isRepeated = true;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    /**
     * Method for checking if task is repeated or not
     *
     * @return boolean - return true if task is repeated else false
     */

    public boolean isRepeated(){

        return isRepeated;
    }

    /**
     * Method for getting the time of the next
     *performing the task after the specified time
     *
     * @param current - current time
     * @return int - the next execution time
     */

    public int nextTimeAfter(int current){
        if (!active){                                            //check if task is active
            return -1;
        }
        if (!isRepeated){                                        //for non-repeated task
            if (current < time) {                                //compare current time with execution time
                return time;
            }
            else {
                return -1;
            }
        }
        else  {                                                  //for non-repeated task
            if (current < start) {                              //compare current time with start time
                return start;
            }
            for (int i = start; i<= end; i+= interval)      //compare current time with each task iteration
                if (current < i) {
                    return i;
                }
        }
        return  -1;
    }
}
