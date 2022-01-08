/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;


import java.io.Serializable;


/**
 *
 * @author USER
 */
public class DaoComponente implements Serializable{
    
    int x,y,tipo,color;
    String nom; 
    double val;
    public DaoComponente(int x, int y, int tipo, String nom, double val, int color){
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.color = color;
        this.nom = nom;
        this.val = val;    
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
