package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MaterialService{
    Repository<Material> materialRepository;

    public void RegistrarMaterial(Material m){
        if(m.getId()!=null){
            throw new RuntimeException("ya existe un material con este id(cambiar la excepcion mas tarde)");
        } else if(m==null || m.getId()==null || m.getId().isEmpty()){
            throw new IllegalArgumentException("El material no existe");
        }
    }
    public void darDeBaja(String idMaterial){
       Optional<Material> variable = materialRepository.findById(idMaterial);
        Material material = variable.get();
        if(idMaterial==null){
            throw new RuntimeException("El material elegido no existe, no se puede dar de baja(cambiar la excepcion mas tarde)");
        }
        if (variable.equals(EstadoMaterial.BAJA)){
            throw new RuntimeException("el material no esta disponible(cambiar la excepcion mas tarde)");
        } else{
            material.setEstado(EstadoMaterial.BAJA);
            materialRepository.save(material);
        }
    }
   public List<Material> listar(){
        List<Material> materiales = List.of();
        materialRepository.listAll(materiales);
    }
}
