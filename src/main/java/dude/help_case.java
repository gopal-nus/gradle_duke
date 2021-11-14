package dude;

/**
 * 
 * @author bgopal
 * This class the case for help
 * It lists out all the options and how to use them
 */
public class help_case {
    /**
     * This method prints out all the tips
     */
    public static void run(){
        System.out.println(list_case.syntax);
        System.out.println(done_case.done_syntax);
        System.out.println(done_case.uncheck_syntax);
        System.out.println(todo_case.syntax);
        System.out.println(event_case.syntax);
        System.out.println(deadline_case.syntax);
        System.out.println(find_case.syntax);
        System.out.println(delete_case.syntax);
    }
}
