package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
    public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/")
    public String showHomePage(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "home-page";
    }
}
