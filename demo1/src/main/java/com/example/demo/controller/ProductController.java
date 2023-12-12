package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    @GetMapping("/category/{id}")
    public String getProductByCategoryId(@PathVariable("id")long id, Model model){
        List<Product> products = productService.getAllByCategoryId(id);
        model.addAttribute("products",products);
        return "product";
    }
    @GetMapping("/form-insert-product")
    public String formInsertProduct(Model model){
        Product product = new Product();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("product",product);
        return "insert-product";
    }
    @PostMapping("/insert-product")
    public String insertProduct(@ModelAttribute("product") Product product){
        productService.insertProduct(product);
        return "redirect:/category/"+product.getCategory().getId();
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        Product product=productRepository.findById(id).orElseThrow(
                IllegalAccessError::new
        );
        productRepository.deleteById(id);
        return "redirect:/category/"+product.getCategory().getId();
    }
    @GetMapping("/update-form-product/{id}")
    public String formUpdateProduct(@PathVariable("id")long id,Model model){
        Product product = productRepository.findById(id).orElseThrow(
                IllegalAccessError::new
        );
        model.addAttribute("product",product);
        return "update-product";
    }
    @PostMapping("/update-product/{id}")
    public String updateProduct(@PathVariable("id")long id,@ModelAttribute("product") Product product){
        productService.updateProduct(product);
        return "redirect:/category/"+product.getCategory().getId();
    }
}
