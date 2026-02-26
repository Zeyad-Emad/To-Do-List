import java.util.ArrayList;
import java.util.Scanner;

// Class represents a Task
class Task {
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }
}

// Main Class
public class ToDoListApp {
    
    // Store tasks in ArrayList
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int choice;
        
        do {
            // Show menu
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Thanks for using the app! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            System.out.println(); // empty line
            
        } while (choice != 5);
    }

    // Show menu function
    public static void showMenu() {
        System.out.println("====== To-Do List App ======");
        System.out.println("1. Add New Task");
        System.out.println("2. Show All Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    // Add task function
    public static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        
        Task newTask = new Task(title);
        tasks.add(newTask);
        
        System.out.println("Task added successfully!");
    }

    // Show tasks function
    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }
        
        System.out.println("====== Task List ======");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[X] Completed" : "[ ] Not Completed";
            System.out.println((i + 1) + ". " + status + " - " + task.getTitle());
        }
    }

    // Complete task function
    public static void completeTask() {
        showTasks();
        
        if (tasks.isEmpty()) return;
        
        System.out.print("Enter task number to complete: ");
        int number = scanner.nextInt();
        
        if (number > 0 && number <= tasks.size()) {
            tasks.get(number - 1).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    // Delete task function
    public static void deleteTask() {
        showTasks();
        
        if (tasks.isEmpty()) return;
        
        System.out.print("Enter task number to delete: ");
        int number = scanner.nextInt();
        
        if (number > 0 && number <= tasks.size()) {
            tasks.remove(number - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid number!");
        }
    }
}