package org.clases.service;

import io.corp.calculator.TracerImpl;
import org.clases.exception.OperationNoContentException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OperacionesServiceImpl implements  OperacionesService{

   private TracerImpl log=new TracerImpl();

    @Override
    public Integer suma(Integer num1, Integer num2) {
        compruebaParametros(num1,num2);
        return num1+num2;
    }

    @Override
    public Integer resta(Integer num1, Integer num2) {
        compruebaParametros(num1,num2);
        return num1-num2;
    }

    /**
     *
     * @param num1
     * @param num2
     */
    private void compruebaParametros(Integer num1, Integer num2) {
        if(num1==null){
            log.trace("Error, no existe el parámetro num1");
            throw new OperationNoContentException("Error, no existe el parámetro num1");
        } if(num2==null){
            log.trace("Error, no existe el parámetro num2");
            throw new OperationNoContentException("Error, no existe el parámetro num2");

        }
    }
}
