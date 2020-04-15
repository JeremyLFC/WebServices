package fr.ubordeaux.tdwebservice.pizzaprojet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * this methode return page submitpizza.jsp
     * @return
     */
    @RequestMapping("/submitpizza")
    public String pizzaController(){
        return "submitpizza";
    }

    /**
     * this methode return page index.jsp
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * this methode return page consultation.jsp
     * @return
     */
    @RequestMapping("/consultation")
    public String pageConsulting(){
        return "consultation";
    }
}
