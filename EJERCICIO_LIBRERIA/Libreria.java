package EJERCICIO_LIBRERIA;

import java.util.HashSet;
import java.util.Iterator;

public class Libreria {
    private HashSet<Libro> biblioRed = new HashSet<>();

    public Libreria() {
    }

    public HashSet<Libro> getBiblioRed() {
        return biblioRed;
    }

    public void setBiblioRed(HashSet<Libro> biblioRed) {
        this.biblioRed = biblioRed;
    }

    public boolean agregarLibro(Libro libro){
        return biblioRed.add(libro);
    }

    public boolean eliminarLibro(int isbn){
        Iterator<Libro> iterador = biblioRed.iterator();
        while(iterador.hasNext()){
            Libro libro =iterador.next();
            if (libro.getISBN()==isbn){
                return biblioRed.remove(libro);
            }
        }
        return false;
    }

    public void mostrarLibros(){
        System.out.println("Los libros ingresados son: ");
        Iterator<Libro> iterador = biblioRed.iterator();
        while(iterador.hasNext()){
            Libro libro =iterador.next();
            System.out.println("-------------------------------");
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("ISBN: "+libro.getISBN());
        }
    }

}
