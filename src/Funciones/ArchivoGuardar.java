/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ArchivoGuardar implements Serializable{
    Map<Object, DaoComponente> map;
    public ArchivoGuardar(Map<Object, DaoComponente> map){
        this.map = map;
    }

    public Map<Object, DaoComponente> getMap() {
        return map;
    }

    public void setMap(Map<Object, DaoComponente> map) {
        this.map = map;
    }
}
