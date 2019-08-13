package garage.com.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import garage.com.webapp.entities.EngineType;
import garage.com.webapp.entities.Vehicle;
import garage.com.webapp.entities.VehicleType;
import garage.com.webapp.services.EngineTypeService;
import garage.com.webapp.services.VehicleService;
import garage.com.webapp.services.VehicleTypeService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class VehicleController
{

    @Autowired
    private VehicleService vehicleSer;

    @Autowired
    private VehicleTypeService  vehicleTypeSer;

    @Autowired 
    private EngineTypeService engineTypeServ;


    @RequestMapping("/Register_Vehicle")
    public String showFormVehicle(Model model)
    {
        Vehicle vehicle=new Vehicle();
        List<VehicleType > listVehicleType=vehicleTypeSer.findAll();
        List<EngineType> listEngineType= engineTypeServ.findAll();


        model.addAttribute("vehicle", vehicle);
        model.addAttribute("listVehicleType", listVehicleType);
        model.addAttribute("listEngineType", listEngineType);
        return "./WebP/newVehicle";
    }


    @RequestMapping(value = "/saveV", method = RequestMethod.POST)
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle)
    {
        vehicleSer.save(vehicle);
        return "redirect:/appointments";
    }

    





}