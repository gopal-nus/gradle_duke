package dude;

/**
 * 
 * @author bgopal
 * this class creates a Task Object.
 * Task object decscribes the task purpose and takes note when a task is completed
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * This method creates a Task Object.
     * The isDone is set to False upon creation.
     * @param description The name of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * This method checks the task isDone status and returns'[X]' or '[ ]'.
     * @return Returns a String '[X]' or '[ ]'
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    /**
     * This method set the isDone status
     * @param x The Boolean of isDone.
     */
    public void markAsDone(boolean x) {
        this.isDone = x;
    }
}