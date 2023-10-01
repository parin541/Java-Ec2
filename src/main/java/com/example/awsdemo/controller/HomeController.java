package com.example.awsdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public String home()
    {
        return "Hello from SpirngBoot Applcaion";
    }

    @GetMapping("/greet/{firstName}")             //http://localhost:8080/demo2023/hello/greet/Parin
    public String sayHello(@PathVariable("firstName") String name) // name : Parin
    {
        return "Hi " + name + ", WELCOME TO SPRING BOOT FRAMEWORK";  // name : Parin
    }

    @GetMapping("/greet/{firstName}/and/{lastName}")   //http://localhost:8080/demo2023/hello/greet/Parin/and/Mistry
    public String sayHello(@PathVariable("firstName") String firstName,
                           @PathVariable("lastName") String lastName)
    {
        return "Hi "+ firstName + " " +lastName + ", WELCOME TO SPRING BOOT FRAMEWORK";
    }
    @GetMapping("/welcome/{user}")    //http://localhost:8080/demo2023/hello/welcome/Pintu
    public String sayWelcome(@PathVariable("user")String name)
    {
        return "Hello "+name+ ", Welcome to system" ;
    }


    @GetMapping("/greetWithParameter") // http://localhost:2001/july2023/hello/greetWithParameter?name=Parin
    public String sayHelloWithParameter(@RequestParam("name")String input)
    {
        return "Hi "+ input + " welcome to springboot with request parameter";
    }

    // Below service is for input
    @GetMapping("/greetWithTwoParameter") // http://localhost:2001/july2023/hello/greetWithTwoParameter?firstname=Parin&lastName=Mistry
    public String sayHelloWithTwoParameters(@RequestParam("firstName") String firstName,
                                            @RequestParam("lastName") String lastName)
    {
        return "HI " +firstName + " " + lastName + ", Welcome to Spring boot";
    }
}
