package app;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Persona;
import model.Propietario;
import model.Veterinario;
import view.FormPersona;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        // Establecer look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            System.err.println("No se pudo establecer el Look and Feel: " + e.getMessage());
        }

        // Ejecutar la interfaz principal en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new FormPersona().setVisible(true);  // Cambia aquí si tienes múltiples formularios
        });
        personas.add(new Propietario("", "", ""));
        personas.add(new Veterinario("", "", ""));
   
    for (Persona p : personas) {
    System.out.println(p.getTipo() + ": " + p.getNombre());
   }
  }
 }