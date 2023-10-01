package com.example.awsdemo.service;
import com.example.awsdemo.controller.CalculateController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CalculateService {

    private static Logger log  = LoggerFactory.getLogger(CalculateController.class);
    public double devide(double fisrtNumber, double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return  fisrtNumber/secondNumber;
    }

    public double add(double firstNumber,double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return firstNumber + secondNumber;
    }

    public double multi(double firstNUmber, double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return  firstNUmber * secondNumber;
    }
    public double substract(double firstNUmber, double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return  firstNUmber - secondNumber;
    }
    public double modulo(double firstNUmber, double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return  firstNUmber % secondNumber;
    }

    public double add(double firstNumber, double secondNumber, double thirdNumber)
    {
        log.info("INSIDE THE CALCUALTE SERVICE");
        return  firstNumber + secondNumber + thirdNumber;
    }

}
