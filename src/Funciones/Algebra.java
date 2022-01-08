/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.io.Serializable;

/**
 *
 * @author OHM
 */
public class Algebra implements Serializable{
    private void pivote(double matriz[][],int piv,int var){
        double temp=0;
        temp=matriz[piv][piv];
        for(int y=0;y<(var+1);y++){
            matriz[piv][y]=matriz[piv][y]/temp;
        }
    }
    
    private void hacerceros(double matriz[][],int piv,int var){
        for(int x=0;x<var;x++){
            if(x!=piv){
                double c=matriz[x][piv];
                for(int z=0;z<(var+1);z++)
                    matriz[x][z]=((-1*c)*matriz[piv][z])+matriz[x][z];
            }
        }
    }
    
    public double[] resolverSistema(double matriz[][], int var){
        
        int  piv=0;
        double res[] =  new double[var];
        for(int a=0;a<var;a++){
            pivote(matriz,piv,var);
            hacerceros(matriz,piv,var);
            piv++;
        }
        for(int x=0;x<var;x++)
           res[x] = matriz[x][var];
        
        return res;
    }

}