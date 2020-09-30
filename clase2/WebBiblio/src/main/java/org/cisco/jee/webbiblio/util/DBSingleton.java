/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.webbiblio.util;

import java.util.ArrayList;
import java.util.List;
import org.cisco.jee.biblioteca.Autor;
import org.cisco.jee.biblioteca.Pais;

/**
 *
 * @author pablo
 */
public class DBSingleton {
    private static DBSingleton obj;
    
    private DBSingleton(){
        
    }
    
    public static DBSingleton getInstance(){
        if(obj == null) obj = new DBSingleton();
        return obj;
    }
    
    public List<Autor> getAutores(){
        List<Autor> autores = new ArrayList<>();
        Autor a = new Autor();
        a.setNombre("Ian");
        a.setApellido("Clements");
        a.setPais(getPaises().get(0));
        
        autores.add(a);
        return autores;
    }
    
    public List<Pais> getPaises() {
        List<Pais> paises = new ArrayList<>();
        Pais p = new Pais("Argentina");
        p.setId(paises.size()+1);
        paises.add(p);
        p = new Pais("Brasil");
        p.setId(paises.size()+1);
        paises.add(p);
        p = new Pais("Chile");
        p.setId(paises.size()+1);
        paises.add(p);
        System.out.println("PAISES EN SINGLETON" + paises.toString());
        return paises;
    }
}
