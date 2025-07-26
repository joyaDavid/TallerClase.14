package persistences;

import java.io.*;
import java.util.List;

public class GestionPersistencia {

    private static GestionPersistencia instancia;

    private GestionPersistencia() {}

    public static synchronized GestionPersistencia getInstance() {
        if (instancia == null) {
            instancia = new GestionPersistencia();
        }
        return instancia;
    }

    public <T extends Serializable> void guardarLista(String ruta, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    public <T extends Serializable> List<T> cargarLista(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Error al leer datos: " + e.getMessage());
        }
        return null;
    }

    public static void crearArchivoSiNoExiste(String ruta) {
        File archivo = new File(ruta);
        try {
            if (!archivo.exists()) {
                archivo.getParentFile().mkdirs();
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("❌ Error creando archivo: " + e.getMessage());
        }
    }
}

