import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ToDo todolist = new ToDo("Today tasks");
        String text = "";
        boolean program = false;

        todolist.restoreTasks();

        while (!program){
            System.out.println("What do you wanna do? Print q to quit. Print add to add task, remove to remove task, mark to mark as complete, modify to modify the task.");
            text = scan.nextLine();
            if (text.equals("add")) {
                System.out.println("What task do you wanna add?");
                String task = scan.nextLine();
                todolist.addTask(task, false);
            }
            else if (text.equals("remove")) {
                System.out.println("What task do you wanna remove?");
                String task = scan.nextLine();
                todolist.removeTask(task);
            }
            else if (text.equals("mark")) {
                System.out.println("What task do you wanna mark as complete?");
                String task = scan.nextLine();
                todolist.markAsDone(task);
            }
            else if (text.equals("modify")) {
                System.out.println("What task do you wanna modify from?");
                String oldtask = scan.nextLine();
                System.out.println("What task do you wanna modify to?");
                String newtask = scan.nextLine();
                todolist.modifyTask(oldtask, newtask);
            }
            else if (text.equals("q")) {
                program = true;
            }
            else {
                System.out.println("Try again");
            }
        }

        todolist.displayTasks();
        todolist.storeTasks();

        scan.close();
    }
}
