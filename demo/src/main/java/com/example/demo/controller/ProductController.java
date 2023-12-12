package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
    public String getAllProductByCategory(Model model, @PathVariable("id") long id){
        List<Product> list = productService.getAllProductByCategory(id);
        model.addAttribute("products",list);
        return "product-page";

    }
    @GetMapping("/insert-product-form")
    public String insertForm(Model model){
        Product product= new Product();
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("CategoryList",categoryList);
        model.addAttribute("product",product);
        return "insert-product-form";
    }
    @PostMapping("/insert-product")
    public String insertProduct(@ModelAttribute("product") Product product){
        productService.insert(product);
        return "redirect:/category/"+product.getCategory().getId();
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found "+id));
        productService.deleteProduct(id);
        return "redirect:/category/"+product.getCategory().getId();
    }
    @GetMapping("/product/update-form/{id}")
    public String updateFormProduct(@PathVariable("id") long id,Model model){
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        model.addAttribute("product",product);
        return "update-product-form";
    }
    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") long id,@Validated Product product){
        productService.updateProduct(product);
        return "redirect:/category/"+product.getCategory().getId();
    }
}
