package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class CarsController {
    private final UserServiceImpl userService;

    public CarsController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getCars(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{count}")
    public String getSomeCars(Model model, @PathVariable("count") int count) {
        model.addAttribute("users", userService.getUsers());
        return null;
    }
}
