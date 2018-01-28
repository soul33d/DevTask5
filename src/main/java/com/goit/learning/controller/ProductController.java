package com.goit.learning.controller;

import com.goit.learning.model.Product;
import com.goit.learning.repositories.ManufacturerRepository;
import com.goit.learning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping(value = "/products")
    public ModelAndView productsList() {
        return new ModelAndView("products", "productsList", productRepository.findAll());
    }

    @GetMapping("/products/create")
    public ModelAndView createProductForm() {
        return new ModelAndView
                ("product_create", "manufacturersList", manufacturerRepository.findAll());
    }

    @PostMapping("/products/create")
    public ModelAndView createProduct(@RequestParam String name,
                                      @RequestParam BigDecimal price,
                                      @RequestParam UUID manufacturer_id) {
        Product product = new Product()
                .setName(name)
                .setPrice(price)
                .setManufacturer(manufacturerRepository.getOne(manufacturer_id));
        productRepository.save(product);
        return productsList();
    }

    @GetMapping("/products/edit")
    public ModelAndView editProductForm(@RequestParam UUID id) {
        ModelAndView modelAndView = new ModelAndView
                ("product_edit", "manufacturersList", manufacturerRepository.findAll());
        modelAndView.addObject("product", productRepository.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/products/edit")
    public ModelAndView editProduct(@RequestParam UUID id,
                                    @RequestParam String name,
                                    @RequestParam BigDecimal price,
                                    @RequestParam UUID manufacturer_id) {
        Product product = new Product()
                .setId(id)
                .setName(name)
                .setPrice(price)
                .setManufacturer(manufacturerRepository.findById(manufacturer_id).get());
        productRepository.save(product);
        return productsList();
    }

    @GetMapping("/products/delete")
    public ModelAndView deleteManufacturer(@RequestParam UUID id) {
        productRepository.deleteById(id);
        return productsList();
    }
}
