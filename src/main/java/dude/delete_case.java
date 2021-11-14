package dude;

import dude.Task;

import java.util.List;

/**
 * 
 * @author bgopal
 * The Class handles the case for delete Task
 * The class checks if the user input is valid and removes a task from the list
 */
public class delete_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "delete -> 'delete <task id>' E.g. delete 1";

    /**
     * The method handles the case for delete Task
     * @param split The tokenised string of the user input
     * @param list The main Task list
     */
    public static void run( String[] split, List<Task> list){
        if(split.length == 2){
            try{
                int list_before = list.size();
                int task_id = Integer.parseInt( split[1]);
                int actual_task_loc = task_id - 1;
                if( task_id <= list.size()){
                    System.out.println("Noted. I've removed this task: ");
                    Task task_to_remove = list.get(actual_task_loc);
                    System.out.println(task_id + "." + task_to_remove.toString());
                    list.remove(actual_task_loc);
                    assert list.size()<list_before;
                }
                else{
                    System.out.println("The list only contains "+ String.valueOf(list.size())+" items");
                }

            } catch (Exception e) {
                System.out.println(try_syntax + syntax);
            }
        }
        else{
            System.out.println(try_syntax + syntax);
        }
    }
}
