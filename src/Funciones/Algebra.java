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
        public void sistemaEcuaciones(int orden){
        double mat[][] = 
        {{3,2,3,3},
         {1,3,1,-6},
         {5,1,3,12}};
        
        double div[] = new double [orden];
        double mul = 1;
        double aux[] = new double[orden];
        for(int i=0;i<orden;i++){
            for(int k=0;k<orden+1;k++){
                if(i==k){
                    div[i] = mat[i][i];     
                }                       
            }                     
        }
        for(int i=0;i<orden;i++){
            new Algebra().mostrarMatriz(orden, mat);
            for(int k=0;k<orden+1;k++){
                mat[i][k] = Math.round(mat[i][k]/div[i]*1000.0)/1000.0;
                for(int f = 1; f<(orden-1);f++){
                    
                }                
            }           
        }
        new Algebra().mostrarMatriz(orden, mat);
    }
    
    public void mostrarMatriz(int orden, double matriz[][]){
        for(int i = 0; i<orden;i++){
            for(int k = 0; k<orden+1; k++){
                System.out.print(matriz[i][k]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new Algebra().sistemaEcuaciones(3);

    }
}
