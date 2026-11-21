package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ProyectoTest {

    private Proyecto crearProyecto() {
        return new Proyecto("P001", "Sistema Web", LocalDate.of(2026, 1, 15),
                "meses", (byte) 6, null, null, "Activo");
    }

    @Test
    public void testGetCodigo() {
        assertEquals("P001", crearProyecto().getCodigo());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Sistema Web", crearProyecto().getTitulo());
    }

    @Test
    public void testGetFechaInicio() {
        assertEquals(LocalDate.of(2026, 1, 15), crearProyecto().getFechaInicio());
    }

    @Test
    public void testSetTitulo() {
        Proyecto p = crearProyecto();
        p.setTitulo("Sistema Móvil");
        assertEquals("Sistema Móvil", p.getTitulo());
    }

    @Test
    public void testSetCodigo() {
        Proyecto p = crearProyecto();
        p.setCodigo("P002");
        assertEquals("P002", p.getCodigo());
    }
}
