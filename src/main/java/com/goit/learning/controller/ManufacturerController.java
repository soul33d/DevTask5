package com.goit.learning.controller;

import com.goit.learning.model.Manufacturer;
import com.goit.learning.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    public ModelAndView manufacturersList() {
        return new ModelAndView("manufacturers")
                .addObject("manufacturersList", manufacturerRepository.findAll());
    }

    @GetMapping("/manufacturers/create")
    public String createManufacturer() {
        return "manufacturer_create";
    }

    @PostMapping("/manufacturers/create")
    public ModelAndView createManufacturer(@RequestParam String name) {
        Manufacturer manufacturer = new Manufacturer().setName(name);
        manufacturerRepository.save(manufacturer);
        return manufacturersList();
    }

    @GetMapping(value = "/manufacturers/edit")
    public ModelAndView doGetEditManufacturer(@RequestParam UUID id, @RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("manufacturer_edit");
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @PostMapping("/manufacturers/edit")
    public ModelAndView editManufacturer(@RequestParam UUID id,
                                         @RequestParam String name) {
        Manufacturer manufacturer = new Manufacturer(id, name);
        manufacturerRepository.save(manufacturer);
        return manufacturersList();
    }

    @GetMapping("/manufacturers/delete")
    public ModelAndView deleteManufacturer(@RequestParam UUID id) {
        manufacturerRepository.deleteById(id);
        return manufacturersList();
    }
}
