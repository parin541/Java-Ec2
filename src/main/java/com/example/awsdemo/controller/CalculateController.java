package com.example.awsdemo.controller;
import com.example.awsdemo.service.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

   private static Logger log  = LoggerFactory.getLogger(CalculateController.class);

    @Autowired   // this annotation will request the spting container to give me and object
    CalculateService calculateService;
    //Dependency Injection
    // Inversion Control

    @GetMapping("/devide/{firstNumber}/{secondNumber}")      //http://localhost:8080/demo2023/calculate/devide/50/30

    public ResponseEntity<Object> devide(@PathVariable("firstNumber") double firstNumber,
                                 @PathVariable("secondNumber")double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE CONTROLLER");
        log.info("FIRST NUMBER: "+firstNumber+" SECOND NUMBER: "+secondNumber);
        if(secondNumber!=0)                                //http://localhost:8080/demo2023/calculate/devide/50/0
                return new ResponseEntity<>("DIVISION IS: " + calculateService.devide(firstNumber,secondNumber), HttpStatus.OK);
        else
            log.error("Divide is not Possible");
            return new ResponseEntity<>("Divide is not Possible", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("add/{firstNumber}/{secondNumber}") // http://localhost:8080/demo2023/calculate/add/50/20
    public ResponseEntity<Object>add(@PathVariable("firstNumber") double firstNumber,
                                     @PathVariable("secondNumber") double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE CONTROLLER");
        log.info("FIRST NUMBER: "+firstNumber+" SECOND NUMBER: "+secondNumber);
        return new ResponseEntity<>("ADDITION IS : " + calculateService.add(firstNumber,secondNumber),HttpStatus.OK);
    }

    @GetMapping("multi/{firstNumber}/{secondNumber}")
    public ResponseEntity<Object> multi(@PathVariable("firstNumber") double firstNumber,
                                        @PathVariable("secondNumber")double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE CONTROLLER");
        log.info("FIRST NUMBER: "+firstNumber+" SECOND NUMBER: "+secondNumber);
        return new ResponseEntity<>("Multiplication : " + calculateService.multi(firstNumber,secondNumber),HttpStatus.OK);
    }

    @GetMapping("sub/{firstNUmber}/{secondNumber}")
    public ResponseEntity<Object> substract(@PathVariable("firstNUmber")double firstNumber,
                                            @PathVariable("secondNumber")double secondNumber)
    {
        log.info("INSIDE THE CALCUALTE CONTROLLER");
        log.info("FIRST NUMBER: "+firstNumber+" SECOND NUMBER: "+secondNumber);

        return new ResponseEntity<>("Substraction : " +calculateService.substract(45,30),HttpStatus.OK);
    }

    @GetMapping("modulo/{firstNumber}/{secondNumber}")
    public ResponseEntity<Object> modulo(@PathVariable("firstNumber") double firstNumber,
                                         @PathVariable("secondNumber")double secondNumber)
    {
        log.info("Inside the calculate service");
        return new ResponseEntity<>("Modulo : " + calculateService.modulo(firstNumber,secondNumber),HttpStatus.OK);
    }
    @GetMapping("addthree/{firstNumber}/{secondNumber}/{thirdNumber}") //http://localhost:8080/demo2023/calculate/addthree/30/20/10
    public ResponseEntity<Object> add(@PathVariable("firstNumber") double firstNumber,
                                      @PathVariable("secondNumber") double secondNumber,
                                      @PathVariable("thirdNumber") double thirdNumber)
    {

        log.info("Inside the calculate service");
        return new ResponseEntity<>("Addition of three : "+ calculateService.add(firstNumber,secondNumber,thirdNumber),HttpStatus.OK);

    }


  // Dependency Injection
  //  Inversion Control
    //@Service
    //@Repository
    //@Component
    //@Bean


}
