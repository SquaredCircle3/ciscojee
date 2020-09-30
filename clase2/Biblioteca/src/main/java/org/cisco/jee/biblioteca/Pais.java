/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.biblioteca;

/**
 *
 * @author Nicolas
 */
public class Pais {
    private int id;
    private String nombre;
            
     public Pais(String nombre){
     this.nombre = nombre;}
     
     public String getNombre(){
     return this.nombre;}
     
     public void setNombre(String nombre){
         this.nombre = nombre;
     }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
