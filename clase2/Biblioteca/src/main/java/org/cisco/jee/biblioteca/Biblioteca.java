/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.biblioteca;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author pablo
 */
public class Biblioteca {
    
    DateTime fecha;
    List<Libro> libros;
    
    public Biblioteca(){
        libros = new ArrayList<>();
        fecha = DateTime.now();
    }
    public void addLibro(Libro libro){
        libros.add(libro);
    }
    
    public DateTime fecha() {
        return fecha;
    }
 
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(Biblioteca.class.getName());
        
        log.debug("ESTE ES UN debug MESSAGE");
        log.info("INFO MESSAGE");
        log.error("ERROR message");
    }
}
