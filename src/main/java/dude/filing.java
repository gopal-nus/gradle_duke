package dude;

import dude.Deadline;
import dude.Event;
import dude.Task;
import dude.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author bgopal
 * This class handles eveything related to files.
 * The class saves, load and checks the files.
 */
public class filing {
    private static final String filename = "File_list.txt";

    /**
     * This method checks if the main file exist and creates one if it doesn't exist.
     */
    public static void checkfile(){
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println(" ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    /**
     * This method loads the content from the file to a Task List
     * @return Returns a Task List
     */
    public static List<Task> load_from_file(){
        List<Task> new_list = new ArrayList<Task>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] sub_task = data.split(",");
                boolean is_done = sub_task[1].contains("1");
                //System.out.println(is_done);
                String task_name = sub_task[2];

                switch (sub_task[0]) {
                case "T":
                    Task new_todo = new Todo(task_name);
                    new_todo.isDone = is_done;
                    new_list.add(new_todo);
                    break;
                case "E":
                    Task new_event = new Event(task_name,sub_task[3]);
                    new_event.isDone = is_done;
                    new_list.add(new_event);
                    break;
                case "D":
                    LocalDateTime dl_by = convert_to_datetime(sub_task[3]);
                    Task new_deadline = new Deadline(task_name,dl_by);
                    new_deadline.isDone=is_done;
                    new_list.add(new_deadline);
                    break;
              
                default:
                      break;
                }
            }
            
            myReader.close();
            } 
        catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        return new_list;
    }

    /**
     * This method saves the content of the list to the main text file
     * @param save_list Takes in a Task List
     */
    public static void save_to_file(List<Task> save_list){
        try {
            FileWriter myWriter = new FileWriter(filename);

            for(Task item:save_list){
                String task_name = item.description;
                String is_done = item.isDone?"1,":"0,";
    
                if(item instanceof Event){
                    Event e = (Event) item;
                    myWriter.write("E,"+ is_done + task_name + ","+e.at);
                    myWriter.write("\n");
                    continue;
                }
                if (item instanceof Todo ){
                    myWriter.write("T,"+ is_done + task_name );
                    myWriter.write("\n");
                    continue;
                }
                if (item instanceof Deadline ){
                    Deadline d = (Deadline) item;
                    myWriter.write("D,"+ is_done + task_name + ","+d.by);
                    myWriter.write("\n");
                    continue;
                }
            }

            myWriter.close();
            } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private static LocalDateTime convert_to_datetime(String s_time) {
        try {
            String[] sa_time = s_time.split("T");
            String[] date = sa_time[0].split("-");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int dayOfMonth = Integer.parseInt(date[2]);

            String[] time = sa_time[1].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            //System.out.println(date[0]+"/" +date[1]+"/"+ date[2]+ " "+ time[0]+ ":"+time[1]);

            return LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        } catch (Exception e) {
            System.out.println(e);
            return LocalDateTime.parse("2015-02-20T06:30:00");
        }
    }
}
