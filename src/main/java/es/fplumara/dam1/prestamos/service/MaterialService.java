package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.MaterialRepositoryImpl;
import es.fplumara.dam1.prestamos.repository.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MaterialService{
    Repository<Material> materialRepository; //PREGUNTAR

    public void RegistrarMaterial(Material m){
        if(m.getId()!=null){
            throw new DuplicadoException("ya existe un material con este id");
        } else if(m.getId()==null || m.getId().isEmpty()){ //PREGUNTAR
            throw new IllegalArgumentException("El material no existe");
        }
    }
    public void darDeBaja(String idMaterial){
        if(idMaterial==null){
            throw new NoEncontradoException("El material elegido no existe, no se puede dar de baja");
        }

       Optional<Material> variable = materialRepository.findById(idMaterial); //PREGUNTAR
        if(variable.isEmpty()){
            //throw new NotFoundException
            throw new RuntimeException("");
        }

        Material material = variable.get(); //PREGUNTAR

        if (material.getEstado().equals(EstadoMaterial.BAJA)){
            throw new MaterialNoDisponibleException("el material no esta disponible");
        } else{
            material.setEstado(EstadoMaterial.BAJA);
            materialRepository.save(material);
        }
    }
   public List<Material> listar(){
        List<Material> materiales = List.of();
        return materialRepository.listAll();
    }
}
