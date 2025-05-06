import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class ToDo {
    private String topic;
    private HashMap<String,Boolean> tasks;
    private String file;

    public ToDo(String topic){
        this.topic = topic;
        tasks = new HashMap<String,Boolean>();
        file = "tasks.json";
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
        if (tasks.containsKey(task)){
            System.out.println("Marking " + task + " as completed");
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

    @SuppressWarnings("unchecked")
    public void storeTasks() throws IOException{
        System.out.println("Storing all the tasks");

        JSONArray arr = new JSONArray();
        for (HashMap.Entry<String,Boolean> task : tasks.entrySet()){
            String description = task.getKey();
            Boolean completion = task.getValue();
            JSONObject obj = new JSONObject();
            obj.put("Task", description);
            obj.put("Completion", completion);
            arr.add(obj);

        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(arr.toJSONString());
        }

        System.out.println("Stored all the tasks");
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
