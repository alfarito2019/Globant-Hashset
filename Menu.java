import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
    static RegistroDeInvitados registro = new RegistroDeInvitados();

    public static void main(String[] args) {
        int seleccion = 0;
        do {
            System.out.println("\n--- Sistema de Gestión de Invitados---");
            System.out.println("1. Agregar invitado ingresando su nombre");
            System.out.println("2. Eliminar invitado ingresando su nombre");
            System.out.println("3. Mostrar la lista actual de invitados");
            System.out.println("4. Salir");

            seleccion = ingresarNumero();
            switch (seleccion) {
                case 1 -> agregarInvitado();
                case 2 -> eliminarInvitado();
                case 3 -> registro.mostrarInvitados();
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
        do{
            System.out.println("Ingrese el nombre del invitado a agregar (el formato es de primer nombre con primer apellido unicamente): ");
            String nombre = scan.nextLine().toUpperCase();
            if(nombre.split(" ").length!=2){
                System.out.println("Unicamente ingresar un nombre y un apellido, por favor.");
            }else{
                if(registro.agregarInvitado(nombre)){
                    System.out.println("Invitado agregado exitosamente");
                    confirmacion=true;
                }else{
                    System.out.println("El invitado ya está agregado");
                }
            }
        }while(!confirmacion);
    }

    public static void eliminarInvitado() {

        boolean confirmacion = false;
        do{
            System.out.println("Ingrese el nombre del invitado a eliminar (el formato es de primer nombre con primer apellido unicamente): ");
            String nombre = scan.nextLine().toUpperCase();
            if(nombre.split(" ").length!=2){
                System.out.println("Unicamente ingresar un nombre y un apellido, por favor.");
            }else{
                if(registro.eliminarInvitado(nombre)){
                    System.out.println("Invitado eliminado exitosamente");
                    confirmacion=true;
                }else{
                    System.out.println("El invitado no está agregado");
                }
            }
        }while(!confirmacion);
    }

}
