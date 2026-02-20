package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseRepository <T extends Identificable> implements Repository<T>{
    Map<String, T> datos;

    //Métodos abstractos
    @Override
    public void save(T elemento) {
        datos.put(elemento.getID(), elemento);
    }

    @Override
    public Optional<T> findById(String id) {
        datos.get(id);
        return Optional.empty();
    }

    @Override
    public List<T> listAll() {
        datos.forEach((s, t) -> System.out.println(s+" "+t));
        return List.of();
    }

    @Override
    public void delete(String id) {
        datos.remove(id);
    }
}
