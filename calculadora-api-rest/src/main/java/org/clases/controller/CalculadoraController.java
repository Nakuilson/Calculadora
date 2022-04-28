package org.clases.controller;

import io.corp.calculator.TracerImpl;
import org.clases.controllers.RestaApiDelegate;
import org.clases.controllers.SumaApiDelegate;
import org.clases.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/operaciones")
public class CalculadoraController implements SumaApiDelegate, RestaApiDelegate {

    @Autowired
    private OperacionesService operacionesService;

    private TracerImpl log=new TracerImpl();


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return SumaApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<Integer> suma(Integer num1, Integer num2) {
        Integer result=operacionesService.suma(num1,num2);
        log.trace("Resultado suma-->"+result);
       return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Integer> resta(Integer num1, Integer num2) {
        Integer result=operacionesService.resta(num1,num2);
        log.trace("Resultado resta-->"+result);
        return ResponseEntity.ok(result);
    }
}
