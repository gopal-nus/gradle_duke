package dude;

import dude.Task;

import java.util.List;

/**
 * 
 * @author bgopal
 * This Class handles the case when a user wants to mark a task as done or uncheck a task.
 * The class also checks if the task is in the list.
 */
public class done_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String done_syntax = "done -> 'done <task id>' E.g. done 1";
    protected static String uncheck_syntax = "uncheck -> 'uncheck <task id>' E.g. uncheck 1";

    /**
     * This method handles the case when a user wants to mark a task as done or uncheck a task.
     * @param splited The tokenised string of the user input
     * @param list The main Task list
     * @param done Set as true for done and false for uncheck.
     */
    public static void run(String[] splited, List<Task> list, boolean done){
        if(splited.length == 2){
            try{
                int donetask = Integer.parseInt(splited[1]) - 1;
                String done_uncheck = done ? "done:":"uncheck:";

                if(list.size() > donetask){
                    list.get(donetask).isDone = done;
                    System.out.println("Nice! I've marked this task as "+ done_uncheck);
                    System.out.println(list.get(donetask).toString() + " " + list.get(donetask).description);
                }
                else
                {
                    System.out.println("No such item in the list");
                }
            } catch (Exception e) {
                String out_syn = done?done_syntax:uncheck_syntax;
                System.out.println(try_syntax + out_syn);
            }

        }
        else{
            String out_syn = done?done_syntax:uncheck_syntax;
            System.out.println(try_syntax + out_syn);
        }
        
    }
}
