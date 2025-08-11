import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class App {
    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "tareas.txt";

    public static void main(String[] args) {
        cargarTareas();

        while (true) {
            System.out.println("\n=== Mi Lista de Tareas ===");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> mostrarTareas();
                case 2 -> agregarTarea();
                case 3 -> eliminarTarea();
                case 4 -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void cargarTareas() {
        try {
            Path path = Paths.get(FILE_NAME);
            if (Files.exists(path)) {
                tasks = new ArrayList<>(Files.readAllLines(path));
            } else {
                Files.createFile(path); // si no existe, lo crea vacío
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las tareas: " + e.getMessage());
        }
    }

    private static void guardarTareas() {
        try {
            Files.write(Paths.get(FILE_NAME), tasks);
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
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
        guardarTareas();
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
        scanner.nextLine();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            guardarTareas();
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("Número de tarea inválido.");
        }
    }
}
