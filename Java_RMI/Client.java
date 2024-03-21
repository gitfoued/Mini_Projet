package Java_RMI;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            liste liste = (liste) Naming.lookup("rmi://localhost:1099/TaskListService");
            Scanner scanner = new Scanner(System.in);
            
            boolean running = true;
            while (running) {
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Supprimer une tâche");
                System.out.println("3. Afficher la liste des tâches");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Entrez la tâche à ajouter : ");
                        scanner.nextLine(); 
                        String taskToAdd = scanner.nextLine();
                        liste.addTask(taskToAdd);
                        System.out.println("Tâche ajoutée avec succès !");
                        break;
                    case 2:
                        System.out.print("Entrez la tâche à supprimer : ");
                        scanner.nextLine(); 
                        String taskToRemove = scanner.nextLine();
                        liste.removeTask(taskToRemove);
                        System.out.println("Tâche supprimée avec succès !");
                        break;
                    case 3:
                        List<String> tasks = liste.getTaskList();
                        System.out.println("Liste des tâches :");
                        for (String task : tasks) {
                            System.out.println(task);
                        }
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Option invalide !");
                        break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}


