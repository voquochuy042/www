package com.example.shoppingapp.controller;

import com.example.shoppingapp.dto.Cart;
import com.example.shoppingapp.model.Product;
import com.example.shoppingapp.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ShoppingController {

    private final ProductRepository productRepository;

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String getHomePage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "home-page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminPage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "admin-page";
    }

    @GetMapping("/buy/{id}")
    public String buyCart(@PathVariable("id") long id, HttpSession session) {
        Object object = session.getAttribute("carts");
        Map<Long, Cart> cartItems;
        if (object == null)
            cartItems = new HashMap<>();
        else
            cartItems = (Map<Long, Cart>) object;
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        int quantity = cartItems.get(product.getId()) == null ? 1 : cartItems.get(product.getId()).getQuantity() + 1;
        Cart cart = Cart.builder()
                .quantity(quantity)
                .product(product)
                .build();
        cartItems.put(id, cart);
        session.setAttribute("carts", cartItems);
        return "redirect:/home";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(HttpSession session, Model model) {
        Object object = session.getAttribute("carts");
        if (object == null) {
            return "redirect:/home";
        }
        HashMap<Long, Cart> cartHashMap = (HashMap<Long, Cart>) object;
        List<Cart> carts = new ArrayList<>(cartHashMap.values());
        double totalPrice = totalPrice(carts);
        model.addAttribute("cartPay", carts);
        model.addAttribute("totalPrice", totalPrice);
        session.setAttribute("carts", cartHashMap);
        return "checkout-page";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable("id") long id, HttpSession session) {
        HashMap<Long, Cart> cartHashMap = (HashMap<Long, Cart>) session.getAttribute("carts");
        cartHashMap.remove(id);
        return "redirect:/checkout";
    }

    @GetMapping("/pay")
    public String payCart(HttpSession session){
        session.removeAttribute("carts");
        return "redirect:/home";
    }
    public double totalPrice(List<Cart> carts) {
        double total = 0;
        for (Cart cart : carts) {
            total += cart.getQuantity() * cart.getProduct().getPrice();
        }
        return total;
    }
}
