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

    private String nombre;
    private Object autor;
    private String isbn;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getAutor() {
        return autor;
    }

    public void setAutor(Object Autor) {
        this.autor = Autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", Autor=" + autor + ", isbn=" + isbn + '}';
    }

}
