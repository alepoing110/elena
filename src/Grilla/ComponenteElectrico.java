package Grilla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import Contenido.Contenido;
import Contenido.PruebaMatriz001;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class ComponenteElectrico implements Serializable{
    int x,y,tipo,color;
    JLabel etiqueta;
    Map<JLabel, ComponenteElectrico> map;
    String nom;
    Contenido panel;    
    double val;
    JPopupMenu menu;
    PruebaMatriz001 frame;
    boolean isNode = false;


    public ComponenteElectrico(int x, int y, JLabel etiqueta, int tipo,
        Map<JLabel,ComponenteElectrico> map, String nom, Contenido panel, double val, int color, PruebaMatriz001 frame){
        this.frame = frame;
        
        this.x = x;
        this.y = y;
        this.etiqueta = etiqueta;
        this.map = map;
        this.nom = nom;
        this.panel = panel;
        this.tipo = tipo;
        this.val = val;
        this.color = color;
        
        LineBorder lb = new LineBorder(Color.BLACK, 1, true);

        
        
        menu = new JPopupMenu();
        JMenuItem item_cambiar_nombre = new JMenuItem("Cambiar nombre");
        JMenuItem item_cambiar_valor = new JMenuItem("Cambiar valor");
        JMenuItem item_girar = new JMenuItem("Girar");
        JMenuItem item_eliminar = new JMenuItem("Eliminar");
        JMenuItem item_es_nodo = new JMenuItem("Nodo");
        
        if(isNode == false)
            item_es_nodo.setFont(new Font("Serfi", Font.PLAIN, 12));
        else{
            item_es_nodo.setFont(new Font("Serfi", Font.BOLD, 12));
            item_es_nodo.setForeground(Color.GREEN);
        }
        item_es_nodo.addActionListener((e)->{
            isNode = (!isNode);

            if(isNode == false)
                item_es_nodo.setFont(new Font("Serfi", Font.PLAIN, 12));
            else{
                item_es_nodo.setFont(new Font("Serfi", Font.BOLD, 12));
                item_es_nodo.setForeground(Color.GREEN);
            }
            
            this.frame.repaint();
            this.panel.repaint();
        });
        item_eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar(e);
            }
        });
        item_girar.addActionListener((e) -> {
          this.setTipo();
          this.panel.repaint();
        });
        
        item_cambiar_nombre.addActionListener((e) -> {
            JDialog jd = new JDialog();
            JTextField jtf = new JTextField(this.nom);
            JLabel jl = new JLabel("Nombre: ");
            
            jtf.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getExtendedKeyCode() == e.VK_ENTER){
                        setNom(jtf.getText());
                        frame.setValores(map.get(etiqueta));
                        panel.repaint();
                    }
                }

                public void keyReleased(KeyEvent e) {
                    
                }
                
            });
            GridLayout experimentLayotut = new GridLayout(0,2);
            jd.setLayout(experimentLayotut);
            jd.setTitle("NOMBRE");
            jd.add(jl);
            jd.add(jtf);
            jd.setSize(100, 75);
            jd.setLocationRelativeTo(null);            
            jd.setVisible(true);
        });
        
        item_cambiar_valor.addActionListener((e) -> {
            JDialog jdv = new JDialog();
            JTextField jtfv = new JTextField(this.val+"");
            JLabel jlv = new JLabel("Valor: ");
            
            jtfv.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getExtendedKeyCode() == e.VK_ENTER){
                        setVal(Double.valueOf(jtfv.getText()));
                    }                        
                }

                public void keyReleased(KeyEvent e) {
                    
                }
                
            });
            GridLayout experimentLayotut = new GridLayout(0,2);
            jdv.setLayout(experimentLayotut);
            jdv.setTitle("VALOR");
            jdv.add(jlv);
            jdv.add(jtfv);
            jdv.setSize(100, 75);
            jdv.setLocationRelativeTo(null);            
            jdv.setVisible(true);
        });
        
        menu.add(item_cambiar_nombre);
        menu.add(item_cambiar_valor);
        menu.add(item_girar);
        menu.add(item_eliminar);
        menu.add(item_es_nodo);
        
        this.etiqueta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(panel.getTipoComponente()!=1){
                    if(e.getButton()==3)
                    menu.show(etiqueta, e.getX(), e.getY());
                    if(e.getButton()==1){                    
                        frame.setValores(map.get(etiqueta));                                
                    }
                }
                else
                    System.out.println("nodo");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                entrar();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        this.etiqueta.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {                    
                mover(evt);                
            }
        });
        
    }
    
    private void entrar(){
        
    }
    
    private void eliminar(ActionEvent e){
        this.panel.remove(etiqueta);
        this.map.remove(etiqueta);        
        this.panel.repaint();
    }
    
    private void mover(java.awt.event.MouseEvent evt) {                     
        
        ComponenteElectrico c = map.get(this.etiqueta);
        //Verificar diferenci entre dragged y posicion del objeto
        //System.out.println("Click X: " + evt.getX() + " -- Click Y: " + evt.getY());
        //System.out.println("posX:" + c.getX() + " -- posY:" + c.getY());
        
        int posX = c.getX();
        int posY = c.getY();          
        
        int valX = evt.getX();
        int valY = evt.getY();
        
        posX = posX + valX;
        posY = posY + valY;
        
        if(posX>=10&&posY>=10){
            if(posX%10!=0 && posY%10!=0){
                
                posX = ((posX / 10)*10);
                posY = ((posY / 10)*10);
                
            }
            c.setX(posX );
            c.setY(posY ) ;        
        }
        this.panel.repaint(); 
    }   

    public int getX() {
            
        return x;
    }

    public int getY() {
        return y;
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public Map<JLabel, ComponenteElectrico> getMap() {
        return map;
    }
    
    public boolean getIsNode() {
        return isNode;
    }

    public String getNom() {
        return nom;
    }

    public JPanel getPanel() {
        return panel;
    }

    public int getTipo() {
        return tipo;
    }

    public double getVal() {
        return val;
    }
    public int getColor(){
        return color;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVal(double val) {
        this.val = val;
    }    
    public void setColor(int color){
        this.color = color;
    }
    public void setTipo(){
        int unidad = this.tipo%10;
        if(unidad <4) 
            this.tipo++;
        else
            this.tipo = this.tipo-3;
        
    }


    public void setIsNode(boolean isNode) {
        this.isNode = isNode;
    }
            
    
}
