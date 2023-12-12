package com.fit.se.controllers;

import com.fit.se.models.Category;
import com.fit.se.models.Product;
import com.fit.se.repositories.ProductRepository;
import com.fit.se.services.CategoryService;
import com.fit.se.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.InterruptedIOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    private final ProductRepository productRepository;

    @GetMapping("/category/{id}")
    public String showProductPage(Model model, @PathVariable("id") long id) {
        List<Product> products = productService.getAllByCategoryId(id);
        model.addAttribute("products", products);
        return "product-page";
    }

    @GetMapping("/insert-form")
    public String showInsertForm(Model model) {
        Product product = new Product();
        List<Category> categories = categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "insert-product-page";
    }

    @PostMapping("/insert")
    public String insertProduct(@ModelAttribute("product") Product product) {
        productService.insert(product);
        return "redirect:/category/" + product.getCategory().getId();
    }

    @GetMapping("/delete/{id}")
    @Secured("ADMIN")
    public String deleteProduct(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found with id " + id));
        productService.deleteProduct(id);
        return "redirect:/category/" + product.getCategory().getId();
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateFormPage(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        model.addAttribute("product", product);
        return "edit-product-page";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, @Validated Product product, BindingResult result) {
        if (result.hasErrors()) {
            product.setId(id);
            return "redirect:/update-form/" + id;
        }
        productService.updateProduct(product);
        return "redirect:/category/" + product.getCategory().getId();

    }
}
