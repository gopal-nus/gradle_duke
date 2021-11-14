package dude;

/**
 * 
 * @author bgopal
 * This class extends from Task.
 * This Event task handles task that has a location.
 */
public class Event extends Task {

    protected String at;

    /**
     * This method extends from Task.
     * The isDone is set to False upon creation.
     * @param description The name of the Event Task
     * @param at The location of the Event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        isDone = false;
    }

    /**
     * This method overrides task to modify the return string.
     * @return Returns Event icon with the done status and name. E.g. [E][X] description (at: location )
     */
    @Override
    public String toString() {
        return "[E]" + super.getStatusIcon() + " " + description + " (at: " + at + ")";
    }
}