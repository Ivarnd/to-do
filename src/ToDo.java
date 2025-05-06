import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public void addTask(String task, Boolean completion){
        tasks.put(task, completion);
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
    }

    public void restoreTasks() throws IOException, FileNotFoundException, ParseException{
        System.out.println("Restoring tasks from JSON file");

        JSONParser parser = new JSONParser();   
        
        try{
            JSONArray arr = (JSONArray) parser.parse(new FileReader(file));
            for (Object o : arr){
                JSONObject obj = (JSONObject) o;

                String task = (String) obj.get("Task");
                Boolean completion = (Boolean) obj.get("Completion");
                addTask(task, completion);
            }
        }
        finally{

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
