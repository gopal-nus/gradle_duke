package dude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author bgopal
 * This class extends from Task.
 * This Deadline task handles task that has a time element.
 */
public class Deadline extends Task {

    protected LocalDateTime by;

    /**
     * This method extends from Task.
     * The isDone is set to False upon creation.
     * @param description The name of the Deadline Task
     * @param by The time of the Deadline
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
        isDone = false;
    }

    /**
     * This method overrides task to modify the return string.
     * @return Returns Deadline icon with the done status and name. E.g. [D][X] description (by: localDateTime )
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "[D]" + super.getStatusIcon() + " " + description + " (by: " + by.format(formatter) + ")";
    }
}