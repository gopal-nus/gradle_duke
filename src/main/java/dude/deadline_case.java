

package dude;

import java.time.LocalDateTime;
import java.util.List;
/**
 * 
 * @author bgopal
 * This Class handles the case for Deadline task
 * The class checks if the user input is valid and creates a Deadline task.
 * The task is added to the list.
 */
public class deadline_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "deadline -> 'deadline <description> /by <yyyy-mm-dd hhmm>' E.g. deadline return book /by 2021-12-01 1800";

    /**
     * This method handles the case for Deadline task
     * @param userInput The entirety of the user input
     * @param split The tokenised string of the user input
     * @param list The main Task list
     */
    public static void run(String userInput, String[] split, List<Task> list){
        if(split.length > 4){
            try {
                String[] substring  = userInput.split(" /by ");
                String dl_task = substring[0].substring(9);
                LocalDateTime dl_by = convert_to_datetime(substring[1]);
                Task c = new Deadline(dl_task, dl_by);
                list.add(c);

                System.out.println("Got it. I've added this task:");
                System.out.println("[D][ ] " + dl_task);
                System.out.println("Now you have "+ list.size() +" tasks in the list.");
            } catch (Exception e) {
                System.out.println("Possible missing /by");
                System.out.println(try_syntax + syntax);
            }
        }
        else{
            System.out.println(try_syntax + syntax);
        }
    }

    /**
     * This method checks and converts the Datetime from string to LocalDateTime
     * If the format is wrong, the default DateTime will be given.
     * @param s_time Takes in datetime is string format
     * @return Returns LocalDateTime
     */
    private static LocalDateTime convert_to_datetime(String s_time){
        try {
            String[] sa_time = s_time.split(" ");
            String[] date = sa_time[0].split("-");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int dayOfMonth = Integer.parseInt(date[2]);
            int hour = Integer.parseInt(sa_time[1]) / 100;
            int minute = Integer.parseInt(sa_time[1]) % 100;
            return LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        } catch (Exception e) {
            System.out.println("Invalid time but to save time, a default time will be assigned");
            return LocalDateTime.parse("2015-02-20T06:30:00");
        }
    }
}
