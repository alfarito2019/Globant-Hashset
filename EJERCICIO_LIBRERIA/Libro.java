package EJERCICIO_LIBRERIA;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int ISBN;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Libro(String autor, int ISBN, String titulo) {
        this.autor = autor;
        this.ISBN = ISBN;
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN == libro.ISBN;
    }

    @Override
    public int hashCode() {
        return ISBN;
    }
}
