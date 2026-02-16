package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public class Portatil extends Material{
    private int ramGB;

    //Constructor
    public Portatil(Set<String> etiquetas, EstadoMaterial estado, String nombre, String id, int ramGB) {
        super(etiquetas, estado, nombre, id);
        this.ramGB = ramGB;
    }

    //getters y setters
    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    //métodos abstractos
    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public String getID() {
        return "";
    }

}
