package garage.com.webapp.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class appController
{

    @RequestMapping("/home")
    public String showHome()
    {
        return "./WebP/homeClient";
    }


    @RequestMapping("/MechanicService")
    public String showMechanicService()
    {
        return "mechanicservice";
    }

    @RequestMapping("/AboutGer")
    public String showAbout()
    {
        return "about";
    }

    @RequestMapping("/ContactGer")
    public String showContact()
    {return "contact";}



    
    


}