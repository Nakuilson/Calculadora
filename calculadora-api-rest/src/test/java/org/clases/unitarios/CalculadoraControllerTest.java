package org.clases.unitarios;

import org.clases.controller.CalculadoraController;
import org.clases.exception.OperationNoContentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class CalculadoraControllerTest {
    @Autowired
    private CalculadoraController calculadoraController;



    @BeforeEach
    private void init(){
        MockitoAnnotations.openMocks(this);
    }

   @Test
    void operacionSuma() {
        ResponseEntity<Integer> resultado= calculadoraController.suma(10,20);
        assertEquals(resultado.getBody(),30);
    }

    @Test
    void operacionResta() {
        ResponseEntity<Integer> resultado= calculadoraController.resta(10,15);
        assertEquals(resultado.getBody(),-5);
    }

    @Test
    void sumaSinParametros() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            calculadoraController.suma(null,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }

    @Test
    void restaSinParametros() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            calculadoraController.resta(null,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }
    @Test
    void sumaSinUnParametro() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            calculadoraController.suma(10,null);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }

    @Test
    void restaSinUnParametro() {
        Throwable throwable =  assertThrows(OperationNoContentException.class, () -> {
            calculadoraController.resta(null,10);
        });
        assertEquals(OperationNoContentException.class, throwable.getClass());
    }
}