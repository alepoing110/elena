
package Funciones;

import Grilla.ComponenteElectrico;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuardarArchivo implements Serializable{

    private String ruta_archivo = "";
    private ComponenteElectrico ce;
    
    public GuardarArchivo(String ruta_archivo){
        this.ruta_archivo = ruta_archivo;                       
    }
    
    public void escribir(ArchivoGuardar archivoGuardar)
    {   
        try {
            //Objeto a guardar en archivo *.DAT
            //Compo clase = new MiClase("CREACI\tON DE OBJETOS");
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.ruta_archivo ));
            //Se escribe el objeto en archivo
            file.writeObject(archivoGuardar);            
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public ArchivoGuardar leer()
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.ruta_archivo ));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            ArchivoGuardar archivoGuardar = (ArchivoGuardar) file.readObject();
            //se cierra archivo
            file.close();            
            return (archivoGuardar);            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo " + ex.toString(), "Error", JOptionPane.ERROR);
            return null;             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo " + ex.toString(), "Error", JOptionPane.ERROR);
            return null;
       }
    }
}