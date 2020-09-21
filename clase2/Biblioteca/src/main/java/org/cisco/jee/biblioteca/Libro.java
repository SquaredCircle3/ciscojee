/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.biblioteca;

/**
 *
 * @author PC
 */
public class Libro {

    private String titulo;
    private Autor autor;
    private String isbn;
    private int anioEdicion;
    private String Editorial;
    
    public Libro(){
        
    }

    public Libro(String nombre, Autor autor, String isbn) {
        this.titulo = nombre;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + titulo + ", Autor=" + autor + ", isbn=" + isbn + '}';
    }

}
