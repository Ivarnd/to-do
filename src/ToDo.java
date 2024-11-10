import java.util.HashMap;

public class ToDo {
    private String topic;
    private HashMap<String,Boolean> tasks;

    public ToDo(String topic){
        this.topic = topic;
        tasks = new HashMap<String,Boolean>();
    }

    public void addTask(String task){
        tasks.put(task, false);
    }

    public void removeTask(String task){
        if (tasks.containsKey(task)){
            System.out.println("Removing " + task);
            tasks.remove(task);
        }
        else {
            System.out.println("No such task");
        }
    }

    public void markAsDone(String task){
        System.out.println("Marking " + task + " as completed");
        if (tasks.containsKey(task)){
            tasks.replace(task, true);
        }
        else {
            System.out.println("No such task");
        }
    }

    public void modifyTask(String oldTask, String newTask){
        System.out.println("Modifying " + oldTask + " to " + newTask);
        if (tasks.containsKey(oldTask)){
            tasks.put(newTask, tasks.get(oldTask));
            tasks.remove(oldTask);
        }
        else {
            System.out.println("No such task");
        }
    }

    public void displayTasks(){
        if (tasks.size() == 0){
            System.out.println("My ToDo list for " + topic + " is empty");
        }
        else {
            System.out.println("My tasks for " + topic);
            for (String task : tasks.keySet()){
                if (tasks.get(task)){
                    System.out.println(task + " is completed.");
                } else{
                    System.out.println(task + " is not completed");
                }
            }
        }
    }
}
