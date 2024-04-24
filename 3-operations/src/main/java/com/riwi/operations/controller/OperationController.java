package com.riwi.operations.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entities.Operation;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {
    @PostMapping("/sum")
    public String sumar(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + " + " + num2 + "= "+ (num1+num2);
    }
    @PostMapping("/rest")
    public String restar(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        return num1 + " - " + num2 + " = "+ (num1-num2);
    }
    @PostMapping("/multi")
    public String multi(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        return num1 + " * " + num2 + " = "+ (num1*num2);
    }
    @PostMapping("/div")
    public String div(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        if (num2 == 0) {
          return "No se puede hacer la operación porque alguno de los dos números es 0.";  
        }else{
            double result = num1/num2;
            return num1 + " / " + num2 + " = "+ (result);
        }
    }
}
