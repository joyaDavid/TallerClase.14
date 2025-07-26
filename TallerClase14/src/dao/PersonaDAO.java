package dao;

import model.Persona;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO {
    private final String archivo = ("data/personas.dat");
   
    public void guardarPersonas(List<Persona> personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            System.err.println("Error guardando personas: " + e.getMessage());
        } 
    }
    public List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        
        crearArchivoSiNoExiste(archivo);
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            personas = (List<Persona>) ois.readObject();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return personas;
    }  
    public static void crearArchivoSiNoExiste(String ruta) {
    File archivo = new File(ruta);
    try {
        if (!archivo.exists()) {
            // Crear carpetas necesarias
            archivo.getParentFile().mkdirs();
            archivo.createNewFile();
        }
    } catch (IOException e) {
        System.err.println("Error al crear archivo: " + e.getMessage());
     }
   }
 }


