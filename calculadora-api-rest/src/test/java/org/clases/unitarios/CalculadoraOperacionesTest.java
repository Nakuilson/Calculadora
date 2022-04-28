package org.clases.unitarios;

import org.clases.exception.OperationNoContentException;
import org.clases.service.OperacionesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculadoraOperacionesTest {
    @Autowired
    private OperacionesService operacionesService;

    @Test
    void operacionSumaEnteros() {
        assertEquals(operacionesService.suma(10,15),25);
    }

    @Test
    void operacionRestaEnteros() {
        assertEquals(operacionesService.resta(10,15),-5);
    }

    @Test
    void sumaSinParametros() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            operacionesService.suma(null,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }

    @Test
    void restaSinParametros() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            operacionesService.resta(null,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }
    @Test
    void sumaSinUnParametro() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            operacionesService.suma(10,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }

    @Test
    void restaSinUnParametro() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            operacionesService.resta(10,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }
}
