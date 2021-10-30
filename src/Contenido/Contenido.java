
package Contenido;

import Grilla.ComponenteElectrico;
import java.awt.*;  
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Contenido extends javax.swing.JPanel implements Serializable{    
    private int tipoComponente = 0;
    PruebaMatriz001 frame;
    private int cantNodos;
    Map<JLabel, ComponenteElectrico> map = new HashMap<>();
    public Contenido(PruebaMatriz001 frame) {               
        initComponents();
        this.frame = frame;
        this.tipoComponente = tipoComponente;
        this.setBackground(Color.getHSBColor(291, 94, 96));
        this.cantNodos = cantNodos;
        
    }
    
    public void agregarComponente(int x, int y, String nom, JLabel e ){
        ComponenteElectrico c = new ComponenteElectrico(x, y, e, tipoComponente, map, nom, this, 0, 0, this.frame);        
        map.put(e, c);
    }
    
    public void paint (Graphics g){
        super.paint(g);        
        
         //Grilla
        g.setColor(Color.LIGHT_GRAY);

        for(int i =10; i<=this.getWidth(); i+=10)
            g.drawLine(i, 10, i, this.getHeight()-10);
        
        for(int k=10; k<=this.getHeight(); k+=10)
            g.drawLine(10, k, this.getWidth()-10, k);
       
        
        //Dibujando componentes
               
        if(tipoComponente !=0){
            for (Map.Entry<JLabel, ComponenteElectrico> lista : map.entrySet()){            
                ComponenteElectrico c = lista.getValue();
                int x = c.getX();
                int y = c.getY();
                if(x%10!=0 || y%10!=0)
                    g.setColor(Color.red);
                else
                    g.setColor(Color.black);
                
                //RESISTENCIA
                //RESISTENCIA HORIZONTAL1
                g.fillOval(x-5, y-5, 10, 10);
                if(c.getTipo() == 11){

                    int[] xp = {x, x+40, x+40, x+50, x+50, x+60, x+100};
                    int[] yp = {y, y, y-10, y+10, y-10, y, y};
                    g.drawLine(x+15, y-5, x+20, y-5);
                    g.drawLine(x+17, y-8, x+17, y-2);
                    g.drawLine(x+80, y-5, x+85, y-5);
                    g.drawPolyline(xp, yp, 7);         

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }     
                //RESISTENCIA HORIZONTAL2
                if(c.getTipo() == 13){

                    int[] xp = {x, x-40, x-40, x-50, x-50, x-60, x-100};
                    int[] yp = {y, y, y-10, y+10, y-10, y, y};
                    g.drawLine(x-15, y-5, x-20, y-5);
                    g.drawLine(x-17, y-8, x-17, y-2);
                    g.drawLine(x-80, y-5, x-85, y-5);
                    g.drawPolyline(xp, yp, 7);         

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);
                }     
                //RESISTENCIA VERTICAL1
                if(c.getTipo() == 12){
                    int[] xp = {x, x, x-10, x+10, x-10, x, x};
                    int[] yp = {y, y+40, y+40, y+50, y+50, y+60, y+100};
                    g.drawPolyline(xp, yp, 7); 

                    g.drawLine(x+5, y+20, x+10, y+20);
                    g.drawLine(x+7, y+17, x+7, y+23);
                    g.drawLine(x+5, y+80, x+10, y+80);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);
                }
                //RESISTENCIA VERTICAL2
                if(c.getTipo() == 14){
                    int[] xp = {x, x, x-10, x+10, x-10, x, x};
                    int[] yp = {y, y-40, y-40, y-50, y-50, y-60, y-100};
                    g.drawPolyline(xp, yp, 7); 

                    g.drawLine(x+5, y-20, x+10, y-20);
                    g.drawLine(x+7, y-17, x+7, y-23);
                    g.drawLine(x+5, y-80, x+10, y-80);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);
                }

                //VOLTAJE CIRCULO -+ V1
                //VOLTAJE -+ HORIZONTAL CIRCULO V1
                if(c.getTipo() == 21){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    g.drawOval(x+40, y-10, 20, 20);

                    g.drawLine(x+45, y+4, x+45, y-5);
                    g.drawLine(x+54, y+3, x+54, y-4);

                    g.drawLine(x+50, y, x+58, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE -+ HORIZONTAL CIRCULO V1
                if(c.getTipo() == 23){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    g.drawOval(x-60, y-10, 20, 20);

                    g.drawLine(x-45, y+4, x-45, y-5);
                    g.drawLine(x-54, y+3, x-54, y-4);                
                    g.drawLine(x-50, y, x-58, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE -+ VERTICAL CIRCULO V1
                if(c.getTipo() == 22){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    g.drawOval(x-10, y+40, 20, 20);

                    g.drawLine(x-2, y+45, x+4, y+45);
                    g.drawLine(x-2, y+54, x+4, y+54);                
                    g.drawLine(x, y+50, x, y+58);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE -+ VERTICAL CIRCULO V1
                if(c.getTipo() == 24){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                    g.drawOval(x-10, y-60, 20, 20);

                    g.drawLine(x-2, y-45, x+4, y-45);
                    g.drawLine(x-2, y-54, x+3, y-54);                
                    g.drawLine(x, y-50, x, y-58);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                
                //VOLTAJE +- CIRCULO V2

                //VOLTAJE +- HORIZONTAL CIRCULO V2
                if(c.getTipo() == 31){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    g.drawOval(x+40, y-10, 20, 20);

                    g.drawLine(x+56, y+4, x+56, y-5);
                    g.drawLine(x+48, y+3, x+48, y-4);
                    g.drawLine(x+44, y, x+51, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE +- HORIZONTAL CIRCULO  V2
                if(c.getTipo() == 33){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    g.drawOval(x-60, y-10, 20, 20);

                    g.drawLine(x-56, y+4, x-56, y-5);
                    g.drawLine(x-48, y+3, x-48, y-4);
                    g.drawLine(x-44, y, x-51, y);
                    
                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE +- VERTICAL CIRCULO V2
                if(c.getTipo() == 32){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    g.drawOval(x-10, y+40, 20, 20);

                    g.drawLine(x-2, y+45, x+4, y+45);
                    g.drawLine(x-2, y+54, x+4, y+54);                
                    g.drawLine(x+1, y+42, x+1, y+49);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE +- VERTICAL CIRCULO V2
                if(c.getTipo() == 34){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                    g.drawOval(x-10, y-60, 20, 20);

                    g.drawLine(x-2, y-45, x+4, y-45);
                    g.drawLine(x-2, y-54, x+4, y-54);                
                    g.drawLine(x+1, y-42, x+1, y-49);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                
                //VOLTAJE +- HORIZONTAL ROMBO V3
                
                 //VOLTAJE -+ HORIZONTAL ROMBO V3
                if(c.getTipo() == 41){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    
                    int[] xp = {x+40, x+50, x+60, x+50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x+45, y+4, x+45, y-5);
                    g.drawLine(x+54, y+3, x+54, y-4);

                    g.drawLine(x+50, y, x+58, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE -+ HORIZONTAL ROMBO V3
                if(c.getTipo() == 43){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);

                    int[] xp = {x-40, x-50, x-60, x-50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-45, y+4, x-45, y-5);
                    g.drawLine(x-54, y+3, x-54, y-4);                
                    g.drawLine(x-50, y, x-58, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE -+ VERTICAL ROMBO V3
                if(c.getTipo() == 42){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y+40, y+50, y+60, y+50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-2, y+45, x+4, y+45);
                    g.drawLine(x-2, y+54, x+4, y+54);                
                    g.drawLine(x, y+50, x, y+58);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE -+ VERTICAL ROMBO V3
                if(c.getTipo() == 44){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);

                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y-40, y-50, y-60, y-50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-2, y-45, x+4, y-45);
                    g.drawLine(x-2, y-54, x+3, y-54);                
                    g.drawLine(x, y-50, x, y-58);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                               
                //VOLTAJE +- ROMBO V4
                //VOLTAJE +- HORIZONTAL ROMBO V4
                if(c.getTipo() == 51){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    
                    int[] xp = {x+40, x+50, x+60, x+50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x+56, y+4, x+56, y-5);
                    g.drawLine(x+48, y+3, x+48, y-4);
                    g.drawLine(x+44, y, x+51, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE +- HORIZONTAL ROMBO  V4
                if(c.getTipo() == 53){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    
                    int[] xp = {x-40, x-50, x-60, x-50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);
                    
                    g.drawLine(x-56, y+4, x-56, y-5);
                    g.drawLine(x-48, y+3, x-48, y-4);
                    g.drawLine(x-44, y, x-51, y);
                    
                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE +- VERTICAL ROMBO V4
                if(c.getTipo() == 52){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y+40, y+50, y+60, y+50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-2, y+45, x+4, y+45);
                    g.drawLine(x-2, y+54, x+4, y+54);                
                    g.drawLine(x+1, y+42, x+1, y+49);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE +- VERTICAL ROMBO V4
                if(c.getTipo() == 54){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                                        
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y-40, y-50, y-60, y-50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-2, y-45, x+4, y-45);
                    g.drawLine(x-2, y-54, x+4, y-54);                
                    g.drawLine(x+1, y-42, x+1, y-49);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                
                //VOLTAJE FLECHAS V5
                //VOLTAJE -> CIRCULO HORIZONTAL FLECHA V5
                if(c.getTipo() == 61){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    g.drawOval(x+40, y-10, 20, 20);

                    g.drawLine(x+43, y, x+57, y);
                    g.drawLine(x+57, y, x+52, y-5);
                    g.drawLine(x+57, y, x+52, y+5);                    

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE -> CIRCULO HORIZONTAL FLECHA V5
                if(c.getTipo() == 63){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    g.drawOval(x-60, y-10, 20, 20);

                    g.drawLine(x-43, y, x-57, y);
                    g.drawLine(x-57, y, x-52, y-5);
                    g.drawLine(x-57, y, x-52, y+5);   
                    
                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE -> CIRCULO VERTICAL FLECHA V5
                if(c.getTipo() == 62){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    g.drawOval(x-10, y+40, 20, 20);
                    
                    g.drawLine(x, y+43, x, y+57);
                    g.drawLine(x, y+57, x-5, y+52);
                    g.drawLine(x, y+57, x+5, y+52);  

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE -> CIRCULO VERTICAL FLECHA V5
                if(c.getTipo() == 64){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                    g.drawOval(x-10, y-60, 20, 20);
                        
                    g.drawLine(x, y-43, x, y-57);
                    g.drawLine(x, y-57, x-5, y-52);
                    g.drawLine(x, y-57, x+5, y-52);  

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                
                //VOLTAJE <- CIRCULO V6

                //VOLTAJE <- HORIZONTAL FLECHA V6
                if(c.getTipo() == 71){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    g.drawOval(x+40, y-10, 20, 20);
                    
                    g.drawLine(x+43, y, x+57, y);
                    g.drawLine(x+43, y, x+48, y-5);
                    g.drawLine(x+43, y, x+48, y+5); 

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE <- HORIZONTAL CIRCULO  V6
                if(c.getTipo() == 73){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    g.drawOval(x-60, y-10, 20, 20);                    
                                        
                    g.drawLine(x-43, y, x-57, y);
                    g.drawLine(x-43, y, x-48, y-5);
                    g.drawLine(x-43, y, x-48, y+5); 
                    
                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE <- VERTICAL CIRCULO V6
                if(c.getTipo() == 72){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    g.drawOval(x-10, y+40, 20, 20);
                    
                    g.drawLine(x, y+43, x, y+57);
                    g.drawLine(x, y+43, x-5, y+48);
                    g.drawLine(x, y+43, x+5, y+48); 

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE <- VERTICAL CIRCULO V6
                if(c.getTipo() == 74){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                    g.drawOval(x-10, y-60, 20, 20);

                    g.drawLine(x, y-43, x, y-57);
                    g.drawLine(x, y-43, x-5, y-48);
                    g.drawLine(x, y-43, x+5, y-48); 

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                
                //VOLTAJE -> HORIZONTAL ROMBO V7                
                 //VOLTAJE -> HORIZONTAL ROMBO V7
                if(c.getTipo() == 81){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    
                    int[] xp = {x+40, x+50, x+60, x+50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x+43, y, x+57, y);
                    g.drawLine(x+57, y, x+52, y-5);
                    g.drawLine(x+57, y, x+52, y+5);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE -> HORIZONTAL ROMBO V7
                if(c.getTipo() == 83){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);

                    int[] xp = {x-40, x-50, x-60, x-50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x-43, y, x-57, y);
                    g.drawLine(x-57, y, x-52, y-5);
                    g.drawLine(x-57, y, x-52, y+5);   

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE -> VERTICAL ROMBO V7
                if(c.getTipo() == 82){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y+40, y+50, y+60, y+50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x, y+43, x, y+57);
                    g.drawLine(x, y+57, x-5, y+52);
                    g.drawLine(x, y+57, x+5, y+52);  

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE -> VERTICAL ROMBO V7
                if(c.getTipo() == 84){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);

                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y-40, y-50, y-60, y-50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x, y-43, x, y-57);
                    g.drawLine(x, y-57, x-5, y-52);
                    g.drawLine(x, y-57, x+5, y-52);  

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }
                               
                //VOLTAJE <- ROMBO V8
                //VOLTAJE <- HORIZONTAL ROMBO V8
                if(c.getTipo() == 91){
                    g.drawLine(x, y, x+40, y);
                    g.drawLine(x+60, y, x+100, y);
                    
                    int[] xp = {x+40, x+50, x+60, x+50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x+43, y, x+57, y);
                    g.drawLine(x+43, y, x+48, y-5);
                    g.drawLine(x+43, y, x+48, y+5); 

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x, y-10, 100, 20);  
                    g.drawString(c.getNom(), x+40, y-10);
                }
                //VOLTAJE <- HORIZONTAL ROMBO  V8
                if(c.getTipo() == 93){
                    g.drawLine(x, y, x-40, y);
                    g.drawLine(x-60, y, x-100, y);
                    
                    int[] xp = {x-40, x-50, x-60, x-50 };
                    int[] yp = {y, y-10, y, y+10};
                    g.drawPolygon(xp, yp, 4);
                    
                    g.drawLine(x-43, y, x-57, y);
                    g.drawLine(x-43, y, x-48, y-5);
                    g.drawLine(x-43, y, x-48, y+5); 
                    
                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-100, y-10, 100, 20);
                    g.drawString(c.getNom(), x-60, y-10);

                }
                //VOLTAJE <- VERTICAL ROMBO V8
                if(c.getTipo() == 92){
                    g.drawLine(x, y, x, y+40);
                    g.drawLine(x, y+60, x, y+100);
                    
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y+40, y+50, y+60, y+50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x, y+43, x, y+57);
                    g.drawLine(x, y+43, x-5, y+48);
                    g.drawLine(x, y+43, x+5, y+48); 

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y, 20, 100);  
                    g.drawString(c.getNom(), x+10, y+50);

                }

                //VOLTAJE <- VERTICAL ROMBO V8
                if(c.getTipo() == 94){
                    g.drawLine(x, y, x, y-40);
                    g.drawLine(x, y-60, x, y-100);
                                        
                    int[] xp = {x, x+10, x, x-10 };
                    int[] yp = {y-40, y-50, y-60, y-50};
                    g.drawPolygon(xp, yp, 4);

                    g.drawLine(x, y-43, x, y-57);
                    g.drawLine(x, y-43, x-5, y-48);
                    g.drawLine(x, y-43, x+5, y-48); 
                    g.drawString("estito es", x, y);

                    this.add(c.getEtiqueta());            
                    c.getEtiqueta().setBounds(x-10, y-100, 20, 100);  
                    g.drawString(c.getNom(), x+10, y-50);

                }

                if(c.getTipo() == 999){
                    this.add(c.getEtiqueta());    
                    c.getEtiqueta().setBounds(x, y-5, 100,10 );
                    g.drawLine(x, y, x+100, y);
                    g.drawString("Coso", x, y);
                }
                if(c.getTipo() == -999){
                    this.add(c.getEtiqueta());    
                    c.getEtiqueta().setBounds(x+5, y, 5, 20);
                    g.drawLine(x, y, x, y+100);
                }
                
            }
            

        }                  
   
    }

    public int getTipoComponente() {
        return tipoComponente;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cant_nodos) {
        this.cantNodos = cant_nodos;
    }
    public void vaciarPanel(){
        map.clear();        
        cantNodos = 0;
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setForeground(new java.awt.Color(51, 102, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1500, 700));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragg(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                moved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salio(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click
        // TODO add your handling code here:
        if(evt.getButton()==evt.BUTTON1 && tipoComponente>=0){
            
            int posX = evt.getX();
            int posY = evt.getY();
            if(posX%10!=0 && posY%10!=0){
                //System.out.println("x0:" + posX+" y0:" + posY);
                posX = (posX / 10)*10;
                posY = (posY / 10)*10;
            }
            
            if(posX>=10&&posY>=10){
                if(tipoComponente == 11){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "R", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 21){
                    JLabel etiqueta = new JLabel("  ");                    
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 31){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 41){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 51){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 61){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 71){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                    if(tipoComponente == 81){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                    if(tipoComponente == 91){
                    JLabel etiqueta = new JLabel("  ");
                    agregarComponente(posX, posY, "V", etiqueta);                    
                    repaint();      
                }  
                if(tipoComponente == 999){
                    JLabel etiqueta = new JLabel("     ");
                    agregarComponente(posX, posY, etiqueta.getText(), etiqueta);                    
                    repaint();     
                }                
            }
            else
                JOptionPane.showMessageDialog(null, "Ingrese lo cooomponentes dentro del área de dibujo");
            
        }
    
            
            
        
            
    }//GEN-LAST:event_click

    private void salio(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salio
        // TODO add your h/andling code here:
    }//GEN-LAST:event_salio

    private void moved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moved
        // TODO add your handling code here:

    }//GEN-LAST:event_moved

    private void dragg(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragg
        
    }//GEN-LAST:event_dragg

    public void setTipoComponente(int tipo_componente){
        this.tipoComponente = tipo_componente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

