package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.prestamo;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PrestamoService {
    Repository<Material> materialRepository;
    Repository<prestamo> prestamoRepository;

    public prestamo crearPrestamo(String idMaterial, String profesor, LocalDate fecha){
        Optional<Material> variable = materialRepository.findById(idMaterial);
        Material material = variable.get();
        if(idMaterial==null || profesor==null || fecha==null){
            throw new IllegalArgumentException("los valores no pueden ser nulos");
        }
        if(variable.isEmpty()){
            throw new RuntimeException("material no encontrado(cambiar excepción)");
        } else if(!material.getEstado().equals(EstadoMaterial.DISPONIBLE)){
            throw new RuntimeException("el material no esta disponible(cambiar excepción)");
        } else{
            prestamo prestamoNuevo = new prestamo(UUID.randomUUID().toString(),idMaterial,profesor,fecha);
            prestamoRepository.save(prestamoNuevo);
            material.setEstado(EstadoMaterial.PRESTADO);
            materialRepository.save(material);
        }
        return null;//no se que devolver en el return
    }

    public void devolverMaterial(String idMaterial) {
        Optional<Material> variable = materialRepository.findById(idMaterial);
        Material material = variable.get();
        if (idMaterial == null) {
            throw new IllegalArgumentException("el material no puede estar vacío");
        }
        if (variable.isEmpty()) {
            throw new IllegalArgumentException("el material no puede estar vacío(cambiar excepción)");
        }
        if (!material.getEstado().equals(EstadoMaterial.PRESTADO)) {
            throw new RuntimeException("El material solicitado no esta prestado(cambiar excepcion)");
        } else {
            material.setEstado(EstadoMaterial.DISPONIBLE);
            materialRepository.save(material);
        }
    }

    public List<prestamo> listarPrestamos(){
        List<prestamo> prestamos = List.of();
        return prestamoRepository.listAll();
    }
}
