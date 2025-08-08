import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Mi Lista de Tareas ===");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    mostrarTareas();
                    break;
                case 2:
                    agregarTarea();
                    break;
                case 3:
                    eliminarTarea();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarTareas() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        System.out.println("\nTareas pendientes:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void agregarTarea() {
        System.out.print("Ingresa la nueva tarea: ");
        String tarea = scanner.nextLine();
        tasks.add(tarea);
        System.out.println("Tarea agregada exitosamente.");
    }

    private static void eliminarTarea() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }
        mostrarTareas();
        System.out.print("Ingresa el número de la tarea a eliminar: ");
        int index = scanner.nextInt();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("Número de tarea inválido.");
        }
    }
}