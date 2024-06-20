package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @GetMapping("/{count}")
    public String getSomeCars(Model model, @PathVariable("count") int count) {
        model.addAttribute("cars", carService.getSomeCars(count));
        return "cars";
    }
}
