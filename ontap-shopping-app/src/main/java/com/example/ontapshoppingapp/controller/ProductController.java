package com.example.ontapshoppingapp.controller;

import com.example.ontapshoppingapp.dto.Cart;
import com.example.ontapshoppingapp.model.Product;
import com.example.ontapshoppingapp.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String Home(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "home-page";
    }
    @GetMapping("/buy/{id}")
    public String addToCart(@PathVariable("id") long id, HttpSession session){
        Object object =session.getAttribute("carts");
        Map<Long, Cart> cartItems ;
        if(object==null) cartItems= new HashMap<>();
        else cartItems = (Map<Long, Cart>) object;
        Product  product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        int quantity = cartItems.get(product.getId())==null ? 1 :cartItems.get(product.getId()).getQuantity()+1;
        Cart cart = Cart.builder()
                .quantity(quantity)
                .product(product)
                .build();
        cartItems.put(id,cart);
        session.setAttribute("carts",cartItems);
        return "redirect:/";
    }
    @GetMapping("/checkout")
    public String checkOutPage(HttpSession session,Model model){
        Object object = session.getAttribute("carts");
        if (object ==null) return "redirect:/";
        HashMap<Long,Cart> cartHashMap = (HashMap<Long, Cart>) object;
        List<Cart> carts = new ArrayList<>(cartHashMap.values());
        double totalPrice=getTotal(carts);
        model.addAttribute("cartPay",carts);
        model.addAttribute("total",totalPrice);
        session.setAttribute("cart",cartHashMap);
        return "checkout-page";
    }
    public double getTotal(List<Cart> carts){
        double total =0;
        for (Cart cart:carts){
            total+=cart.getQuantity()*cart.getProduct().getPrice();
        }
        return total;
    }
}
