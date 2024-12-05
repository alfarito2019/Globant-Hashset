package EJERCICIO_LIBRERIA;

import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
    static Libreria libreria = new Libreria();

    public static void main(String[] args) {
        int seleccion = 0;
        do {
            System.out.println("\n--- Sistema de Gestión de Libros---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Eliminar Libro");
            System.out.println("3. Mostrar la lista actual de libros");
            System.out.println("4. Salir");

            seleccion = ingresarNumero();
            switch (seleccion) {
                case 1 -> agregarInvitado();
                case 2 -> eliminarInvitado();
                case 3 -> libreria.mostrarLibros();
                case 4 -> System.out.println("Saliendo ...");
                default -> System.out.println("Opción no permitida");
            }

        } while (seleccion != 4);
    }

    public static int ingresarNumero() {
        boolean esNumber = false;
        int num = 0;

        do {
            esNumber = true;
            try {
                num = Integer.valueOf(scan.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Error, ingrese un número");
                esNumber = false;
            }

        } while (!esNumber);

        return num;
    }

    public static void agregarInvitado() {

        boolean confirmacion = false;
        do {
            System.out.println("Ingrese el titulo del libro a agregar: ");
            String titulo = scan.nextLine();
            System.out.println("Ingrese el autor del libro a agregar: ");
            String autor = scan.nextLine();
            System.out.println("Ingrese el ISBN del libro a agregar: ");
            int isbn = ingresarNumero();
            if (libreria.agregarLibro(new Libro(autor, isbn, titulo))) {
                System.out.println("Libro agregado exitosamente");
                confirmacion = true;
            } else {
                System.out.println("El libro ya está agregado");
            }
        } while (!confirmacion);
    }

    public static void eliminarInvitado() {

        boolean confirmacion = false;
        do {
            System.out.println("Ingrese el ISBN del libro a eliminar: ");
            int isbn = ingresarNumero();

            if (libreria.eliminarLibro(isbn)) {
                System.out.println("Invitado eliminado exitosamente");
                confirmacion = true;
            } else {
                System.out.println("El libro no está agregado");
            }

        } while (!confirmacion);
    }
}
