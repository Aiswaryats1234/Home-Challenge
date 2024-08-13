package ToDoDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<ToDo> todos = new ArrayList<>();

    public void addTask(String title) {
        todos.add(new ToDo(title));
        System.out.println("Task added: " + title);
    }

    public void editTask(int index, String newTitle) {
        if (index < 0 || index >= todos.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        todos.get(index).setTitle(newTitle);
        System.out.println("Task updated to: " + newTitle);
    }

    public void markTaskAsComplete(int index) {
        if (index < 0 || index >= todos.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        todos.get(index).markAsCompleted();
        System.out.println("Task marked as complete: " + todos.get(index).getTitle());
    }

    public void displayTasks() {
        System.out.println("Your To-Do List:");
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ". " + todos.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    toDoList.addTask(title);
                    break;
                case 2:
                    toDoList.displayTasks();
                    System.out.print("Enter task number to edit: ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();
                    toDoList.editTask(editIndex, newTitle);
                    break;
                case 3:
                    toDoList.displayTasks();
                    System.out.print("Enter task number to mark as complete: ");
                    int completeIndex = scanner.nextInt() - 1;
                    toDoList.markTaskAsComplete(completeIndex);
                    break;
                case 4:
                    toDoList.displayTasks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

