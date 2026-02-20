package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseRepository <T extends Identificable> implements Repository<T>{
    private Map<String, T> datos;

    public BaseRepository() {
        datos = new HashMap<>();
    }

    //Métodos abstractos
    @Override
    public void save(T elemento) {
        datos.put(elemento.getID(), elemento);
    }

    @Override
    public Optional<T> findById(String id) {
        T elemento = datos.get(id);
        return Optional.ofNullable(elemento);
    }

    @Override
    public List<T> listAll() {
        return datos.values().stream().toList();
    }

    @Override
    public void delete(String id) {
        datos.remove(id);
    }
}
