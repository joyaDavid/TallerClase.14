package controller;

import dao.PersonaDAO;
import model.Persona;
import java.util.List;

public class Personaontroller {
    private final PersonaDAO dao;
    private List<Persona> personas;

    public Personaontroller() {
        this.dao = new PersonaDAO();
        this.personas = dao.cargarPersonas();
    }
    
    public void agregar(Persona persona) {
        personas.add(persona);
        dao.guardarPersonas(personas);
    }
    
    public List<Persona> listar() {
        return personas;
    }

    public void eliminarPorIdentificacion(String id) {
        personas.removeIf(p -> p.getIdentificacion().equals(id));
        dao.guardarPersonas(personas);
    }
}

