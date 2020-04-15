package fr.ubordeaux.tdwebservice.pizzaprojet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hellocontroller")
    @ResponseBody
    public String helloController() {
        return "Hello world! This is our first controller for this project!";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

}
