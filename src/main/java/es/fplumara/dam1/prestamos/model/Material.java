package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public abstract class Material implements Identificable{
    private String id;
    private String nombre;
    private EstadoMaterial estado;
    private Set<String> etiquetas;
    //Constructor

    public Material(Set<String> etiquetas, EstadoMaterial estado, String nombre, String id) {
        this.etiquetas = etiquetas;
        this.estado = estado;
        this.nombre = nombre;
        this.id = id;
    }
    //Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoMaterial getEstado() {
        return estado;
    }

    public Set<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEstado(EstadoMaterial estado) {
        this.estado = estado;
    }

    public abstract String getTipo();

}
