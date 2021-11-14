package dude;

import java.util.List;

/**
 * 
 * @author bgopal
 * This Class handles the case for Event task
 * The class checks if the user input is valid and creates a Event task.
 * The task is added to the list.
 */
public class event_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "event -> 'event <description> /at <location string>' E.g. event meeting /at holland v MON 2-4pm";

    /**
     * This method handles the case for Event task
     * @param userInput The entirety of the user input
     * @param split The tokenised string of the user input
     * @param list The main Task list
     */
    public static void run(String userInput, String[] split, List<Task> list){
        if(split.length > 3){
            String[] substring  = userInput.split(" /at ");
            String dl_task = substring[0].substring(6);
            String dl_by = substring[1];
            Task d = new Event(dl_task,dl_by);
            list.add(d);

            System.out.println("Got it. I've added this task:");
            System.out.println("[E][ ] " + dl_task);
            System.out.println("Now you have "+ list.size() +" tasks in the list.");
            
        }
        else{
            System.out.println(try_syntax + syntax);
        }
    }
}
