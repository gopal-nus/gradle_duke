package dude;

/**
 * 
 * @author bgopal
 * This class extends from Task.
 * This class handles all basic task
 */
public class Todo extends Task {
    /**
     * This method extends from Task.
     * The isDone is set to False upon creation.
     * @param description The name of the To-do Task
     */
    public Todo(String description) {
        super(description);
        isDone = false;
    }

    /**
     * This method overrides task to modify the return string.
     * @return Returns To-do icon with the done status and name. E.g. [T][X] description
     */
    @Override
    public String toString() {
        return "[T]" + super.getStatusIcon() + " " + description;
    }
}