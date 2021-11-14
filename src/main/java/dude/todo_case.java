package dude;

import java.util.List;
/**
 * 
 * @author bgopal
 * This Class handles the case for To-do task
 * The class checks if the user input is valid and creates a To-do task.
 * The task is added to the list.
 */
public class todo_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "todo -> 'todo <description>' E.g. todo pack bag";

    /**
     * This method handles the case for To-do task
     * @param userInput The entirety of the user input
     * @param split The tokenised string of the user input
     * @param list The main Task list
     */
    public static void run(String userInput, String[] split, List<Task> list){
        String parentStringValue = userInput.substring(userInput.indexOf(" ")+1);

        if(split.length == 1){
            System.out.println(try_syntax + syntax);
        }
        else{
            Task x = new Todo(parentStringValue);
            list.add(x);

            System.out.println("Got it. I've added this task:");
            System.out.println("[T][ ] " + parentStringValue);
            System.out.println("Now you have "+ list.size() +" tasks in the list.");
        }
    }
}
