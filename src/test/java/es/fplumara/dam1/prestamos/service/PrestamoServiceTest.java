package es.fplumara.dam1.prestamos.service;


import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.model.Proyector;
import es.fplumara.dam1.prestamos.repository.PrestamoRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Collections;

class PrestamosServiceTest {

    // TODO (alumnos): añadir JUnit 5 y Mockito en el pom.xml y completar:
    //
    // - crearPrestamo_ok_cambiaEstado_y_guarda()
    // - crearPrestamo_materialNoExiste_lanzaNoEncontrado()
    // - crearPrestamo_materialNoDisponible_lanzaMaterialNoDisponible()
    // - devolverMaterial_ok_cambiaADisponible()
    //
    // Requisito: usar mocks de repositorios y verify(...)
    @Mock
        private PrestamoService prestamoService;
        private PrestamoRepositoryImpl prestamoRepository;
    @ParameterizedTest
    @CsvSource({
            "Wood1213, Marcos, 2024-23-12"
    })
    public void crearPrestamo_ok_cambiaEstado_y_guarda(String idMaterial, String profesor, LocalDate fecha){
        Material material  = new Proyector(10, Collections.singleton("oferta"), EstadoMaterial.DISPONIBLE,"LumensOffer","Wood1213");
        Prestamo p = prestamoService.crearPrestamo("Wood1213", profesor, fecha);
        prestamoRepository.save(p);
    }
}
