/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.biblioteca;

/**
 *
 * @author pablo
 */
public class Autor {
    private String nombre;
    private String apellido;
    private Pais pais;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
