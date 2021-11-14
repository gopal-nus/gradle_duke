package dude;

import java.util.List;

/**
 * 
 * @author bgopal
 * This class handles the find case.
 * The class will look for one keyword in the return text.
 * Datatime are also included in the return text
 */
public class find_case {
    private static final String try_syntax = "Invalid syntax. Try: ";
    protected static String syntax = "find -> 'find <keyword>' E.g. find event";
    
    /**
     * This method handles the find case.
     * @param split Takes in the tokenise user input
     * @param list The main Task list
     */
    public static void run(String[] split, List<Task> list){
        if(split.length == 2){
            int counter = 1;
            int found = 0;

            for(Task item : list){
                if(item.description.contains(split[1])){
                    System.out.println(counter + "."+ item);
                    found++;
                }
                counter++;
            }
            System.out.println(found + " Task found.");
        }
        else{
            System.out.println(try_syntax + syntax);
        }
    }
}
