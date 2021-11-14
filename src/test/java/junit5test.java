import dude.delete_case;
import dude.done_case;
import dude.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class task_test {
    Task g = new Task("sth");

    @Test
     void status_icon_false(){
        Assertions.assertEquals("[ ]",g.getStatusIcon());
    }

    @Test
    void status_icon_true(){
        g.markAsDone(true);
        Assertions.assertEquals("[X]",g.getStatusIcon());
    }

    @Test
    void status_icon_set_false(){
        g.markAsDone(false);
        Assertions.assertEquals("[ ]",g.getStatusIcon());
    }

}

class todo_task{
    Todo td = new Todo("pack bag") ;

    @Test
    void status_icon_false(){
        Assertions.assertEquals("[T][ ] pack bag",td.toString());
    }

    @Test
    void status_icon_true(){
        td.markAsDone(true);
        Assertions.assertEquals("[T][X] pack bag",td.toString());
    }

    @Test
    void status_icon_set_false(){
        td.markAsDone(false);
        Assertions.assertEquals("[T][ ] pack bag",td.toString());
    }

}

class event_task{
    String name = "bring milk";
    String at = "Mon 2-3PM";
    Event evt = new Event(name,at);

    @Test
    void status_icon_false(){
        Assertions.assertEquals("[E][ ] "+name+" (at: "+at+")",evt.toString());
    }

    @Test
    void status_icon_true(){
        evt.markAsDone(true);
        Assertions.assertEquals("[E][X] "+name+" (at: "+at+")",evt.toString());
    }

    @Test
    void status_icon_set_false(){
        evt.markAsDone(false);
        Assertions.assertEquals("[E][ ] "+name+" (at: "+at+")",evt.toString());
    }
}

class deadline_task{
    String name = "pack banana";
    LocalDateTime ldt = LocalDateTime.of(2021,12,11,10,9,0);
    Deadline dl = new Deadline(name,ldt);

    @Test
    void status_icon_false(){
        Assertions.assertEquals("[D][ ] "+name+" (by: 2021-12-11 10:09)",dl.toString());
    }

    @Test
    void status_icon_true(){
        dl.markAsDone(true);
        Assertions.assertEquals("[D][X] "+name+" (by: 2021-12-11 10:09)",dl.toString());
    }

    @Test
    void status_icon_set_false(){
        dl.markAsDone(false);
        Assertions.assertEquals("[D][ ] "+name+" (by: 2021-12-11 10:09)",dl.toString());
    }

}

class todo_case_test{

    @Test
    void valid_todo(){
        String userInput = "todo pack bag";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        todo_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());
    }

    @Test
    void invalid_todo(){
        String userInput = "todo";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        todo_case.run(userInput,split,list);
        Assertions.assertEquals(0,list.size());
    }
}

class event_case_test{
    @Test
    void valid_event(){
        String userInput = "event meeting /at holland v MON 2-4pm";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        event_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());
    }


    @ParameterizedTest
    @ValueSource(strings = {"event","event meeting","event meeting /at"})
    void invalid_event(String userInput){
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        event_case.run(userInput,split,list);
        Assertions.assertEquals(0,list.size());
    }
}

class deadline_case_test{
    @Test
    void valid_deadline(){
        String userInput = "deadline return book /by 2021-12-01 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());
    }


    @ParameterizedTest
    @ValueSource(strings = {"deadline","deadline return book","deadline return book /by","deadline return book at the lib"})
    void invalid_deadline(String userInput){
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);
        Assertions.assertEquals(0,list.size());
    }

    @Test
    void invalid_deadline_time(){
        String userInput = "deadline return book /by 20211201 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());
    }
}

class done_undone_test{

    @Test
    void done_check_todo(){
        String userInput = "todo pack bag";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        todo_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[X]",fact);
    }

    @Test
    void done_check_event(){
        String userInput = "event meeting /at holland v MON 2-4pm";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        event_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[X]",fact);
    }

    @Test
    void done_check_deadline(){
        String userInput = "deadline return book /by 2021-12-01 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[X]",fact);
    }

    @Test
    void undone_check_todo(){
        String userInput = "todo pack bag";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        todo_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);
        done_case.run(done_split,list,false);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[ ]",fact);
    }

    @Test
    void undone_check_event(){
        String userInput = "event meeting /at holland v MON 2-4pm";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        event_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);
        done_case.run(done_split,list,false);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[ ]",fact);
    }

    @Test
    void undone_check_deadline(){
        String userInput = "deadline return book /by 2021-12-01 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);

        String input = "done 1";
        String[] done_split = input.split(" ");
        done_case.run(done_split,list,true);
        done_case.run(done_split,list,false);

        String fact = list.get(0).getStatusIcon();
        Assertions.assertEquals("[ ]",fact);
    }
}

class delete_test{

    @Test
    void valid_delete(){
        String userInput = "deadline return book /by 2021-12-01 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());

        String input = "delete 1";
        String[] split_in = input.split(" ");
        delete_case.run(split_in,list);
        Assertions.assertEquals(0,list.size());

    }

    @ParameterizedTest
    @ValueSource(strings = {"delete","delete a","delete 2"})
    void invalid_delete(String input){
        String userInput = "deadline return book /by 2021-12-01 1800";
        String[] split = userInput.split(" ");
        List<Task> list = new ArrayList<>();
        deadline_case.run(userInput,split,list);
        Assertions.assertEquals(1,list.size());

        String[] split_in = input.split(" ");
        delete_case.run(split_in,list);
        Assertions.assertEquals(1,list.size());

    }
}

