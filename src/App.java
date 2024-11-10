public class App {
    public static void main(String[] args) throws Exception {
        ToDo todolist = new ToDo();

        todolist.addTask("Buy groceries");
        todolist.addTask("Complete homework");
        todolist.addTask("Play basketball");
        todolist.removeTask(0);

        todolist.displayTasks();
    }
}
