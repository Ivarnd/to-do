public class App {
    public static void main(String[] args) throws Exception {
        ToDo todolist = new ToDo("Today tasks");

        todolist.addTask("Buy groceries");
        todolist.addTask("Complete homework");
        todolist.addTask("Play basketball");
        todolist.displayTasks();
        todolist.removeTask("Buy groceries");
        todolist.markAsDone("Complete homework");
        todolist.markAsDone("Him");
        todolist.modifyTask("Complete homework", "Complete math");

        todolist.displayTasks();
    }
}
