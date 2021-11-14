package dude;

import java.util.List;
import java.util.Scanner;

public class Duke {

    protected static List<Task> list_of_task;

    public static void main(String[] args) {
        filing.checkfile();
        list_of_task = filing.load_from_file();
        
        System.out.println("Hello! I'm Dude, your Bro.\nWhat can I do for ya mate?" );
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        

        while(!userInput.equals("bye") ){
            
            String[] split = userInput.split(" ");
            switch(split[0])
            {
                case "list":
                    list_case.run(split,list_of_task);
                    break;

                case "done":
                    done_case.run(split, list_of_task,true);
                    filing.save_to_file(list_of_task);
                    break;

                case "todo":
                    todo_case.run(userInput, split, list_of_task);
                    filing.save_to_file(list_of_task);
                    break;
                
                case "deadline":
                    deadline_case.run(userInput, split, list_of_task);
                    filing.save_to_file(list_of_task);
                    break;

                case "event":
                    event_case.run(userInput, split, list_of_task);
                    filing.save_to_file(list_of_task);
                    break;

                case "delete":
                    delete_case.run(split, list_of_task);
                    filing.save_to_file(list_of_task);
                    break;
                
                case "uncheck":
                    done_case.run(split, list_of_task,false);
                    filing.save_to_file(list_of_task);
                    break;

                case "find":
                    find_case.run(split, list_of_task);
                    break;

                case "help":
                    help_case.run();
                    break;

                default:
                    System.out.println("Invalid syntax. Try 'help' for tips");
                    break;
            }

            userInput = scan.nextLine();
        }

        System.out.println("Hooroo. Catch ya later mate!" );
        scan.close();
    }
}
