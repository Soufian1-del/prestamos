package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public class Proyector extends Material{
    private int lumens;

    //Constructor
    public Proyector(int lumens, Set<String> etiquetas, EstadoMaterial estado, String nombre, String id) {
        super(etiquetas, estado, nombre, id);
        this.lumens = lumens;
    }

    //Métodos abstractos
    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public String getID() {
        return "";
    }

    //getters y setters
    public int getLumens() {
        return lumens;
    }

    public void setLumens(int lumens) {
        this.lumens = lumens;
    }
}
