package es.fplumara.dam1.prestamos.model;

import java.time.LocalDate;

public class prestamo implements Identificable{
    private String id;
    private String idMaterial;
    private String profesor;
    private LocalDate fecha;

    @Override
    public String getID() {
        return "";
    }
}
