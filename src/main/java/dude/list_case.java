package dude;

import dude.Deadline;
import dude.Event;
import dude.Task;
import dude.Todo;

import java.util.List;

/**
 * 
 * @author bgopal
 * The Class handles the case for list.
 * The list option can be overloaded with other parameter
 */
public class list_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "list -> 'list' or 'list <task>' E.g. list event";

    /**
     * The method handles the case for list.
     * @param split The tokenised string of the user input
     * @param list The main Task list
     */
    public static void run(String[] split,List<Task> list){
        if(split.length == 1){
            assert split.length == 1;
            System.out.println("Here are the tasks in your list:" );
            int counter = 1;
            for (Task item : list) {
                System.out.println(counter + "." + item.toString());
                counter++;
            }
            return;
        }

        if(split.length == 2){
            if(split[1].contains("event")){
                System.out.println("Here are the event in your list:" );
                int counter = 1;
                for (Task item : list) {
                    if(item instanceof Event){
                        System.out.println(counter + "." + item);
                    }
                    counter++;
                }
                assert counter == list.size();
                return;
            }
            if(split[1].contains("todo")){
                System.out.println("Here are the to-do in your list:" );
                int counter = 1;
                for (Task item : list) {
                    if(item instanceof Todo){
                        System.out.println(counter + "." + item);

                    }
                    counter++;
                }
                return;
            }
            if(split[1].contains("deadline")){
                System.out.println("Here are the deadline in your list:" );
                int counter = 1;
                for (Task item : list) {
                    if(item instanceof Deadline){
                        System.out.println(counter + "." + item);

                    }
                    counter++;
                }
                return;
            }
            System.out.println(try_syntax + syntax);
        }
        else{
            System.out.println(try_syntax + syntax);
        }

    }

}

