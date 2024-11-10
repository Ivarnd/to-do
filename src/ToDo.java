import java.util.ArrayList;

public class ToDo {
    private ArrayList<String> tasks = new ArrayList<String>();

    public void addTask(String task){
        tasks.add(task);
    }

    public void removeTask(int index){
        tasks.remove(index);
    }

    public void displayTasks(){
        for (int i = 0; i < tasks.size(); i++){
            System.out.println(i + ". " + tasks.get(i));
        }


    }
}
