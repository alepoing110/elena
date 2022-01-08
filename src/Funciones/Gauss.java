/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Gauss {
    
    static void muestramatriz(double matriz[][], int var){
        for(int x=0;x<var;x++){
            for(int y=0;y<(var+1);y++)
                System.out.print(" "+matriz[x][y]+" |");
            System.out.println("");
        }

    }
    
    static void pivote(double matriz[][],int piv,int var){
        double temp=0;
        temp=matriz[piv][piv];
        for(int y=0;y<(var+1);y++){
            matriz[piv][y]=matriz[piv][y]/temp;
        }
    }
    
    static void hacerceros(double matriz[][],int piv,int var){
        for(int x=0;x<var;x++){
            if(x!=piv){
                double c=matriz[x][piv];
                for(int z=0;z<(var+1);z++)
                    matriz[x][z]=((-1*c)*matriz[piv][z])+matriz[x][z];
            }
        }
    }
    
    public static void main(String args[]){
        Scanner leer=new Scanner(System.in);
        int var=0, piv=0;
        double matriz[][] = {{3,-5,7,9,2},
         {9,3,-2,3,2},
         {3,1,3,3,9},
         {-8,3,2,3,2}
        };

        System.out.println("\t ** Este programa nos muestra la solución de un sistema de ecuaciones \n\t\tlineales a través del método Gauss_Jordan **");
        System.out.println("\n¿Cuantas variables tiene tu sistema?");
        var=leer.nextInt();
        //matriz=new double[var][var+1];
        /*
        for(int x=0;x<var;x++){
            for(int y=0;y<(var+1);y++){
                System.out.println("Ingresa la constante de la posicion: A["+(x+1)+"]["+(y+1)+"]");
                matriz[x][y]=leer.nextFloat();
            }

        }*/

        for(int a=0;a<var;a++){
            pivote(matriz,piv,var);

            System.out.println("\tRenglon "+(a+1)+" entre el pivote");
            muestramatriz(matriz,var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(matriz,piv,var);

            muestramatriz(matriz,var);
            System.out.println("");
            piv++;
        }
        for(int x=0;x<var;x++)
            System.out.println("La variable X"+(x+1)+" es: "+matriz[x][var]);

        }

}