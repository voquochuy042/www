package com.example.tuan6.frontend.controllers;

import com.example.tuan6.backend.entities.Post;
import com.example.tuan6.backend.entities.PostComment;
import com.example.tuan6.backend.entities.User;
import com.example.tuan6.backend.repository.UserRepository;
import com.example.tuan6.backend.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/show-log-form")
    public String showLogForm(Model model, HttpSession session) {
        User user = new User();
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        model.addAttribute("logFail", false);
        return "user/logIn";
    }

    @GetMapping("/infoUser")
    public String showUser(Model model, HttpSession session){
        model.addAttribute("user", (User) session.getAttribute("user"));
        return "user/infoUser";
    }

    @GetMapping("/logIn")
    public String logIn(@ModelAttribute("user") User user, HttpSession session, Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        if (((User) session.getAttribute("user")).getEmail() == null) {
            List<User> users = userRepository.findByEmailAndPasswordHash(user.getEmail(), user.getPasswordHash());
            if (users.isEmpty() && page.isEmpty()) {
                model.addAttribute("logFail", true);
                return "user/logIn";
            }
            User u = users.get(0);
            u.setLastLogin(LocalDateTime.now());
            userRepository.save(u);
            session.setAttribute("user", u);
        }
        model.addAttribute("user", (User) session.getAttribute("user"));
        int currPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Post> postPage = postService.findAll(currPage - 1, pageSize, "updatedAt", "desc");
        model.addAttribute("postPage", postPage);
        PostComment postComment = new PostComment();
        Post post = new Post();
        model.addAttribute("comment", postComment);
        model.addAttribute("post", post);
        int totalPage = postPage.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().toList();
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "user/user";
    }

    @GetMapping("/show-register-form")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @GetMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setRegisteredAt(LocalDateTime.now());
        userRepository.save(user);
        return "user/logIn";
    }
}
