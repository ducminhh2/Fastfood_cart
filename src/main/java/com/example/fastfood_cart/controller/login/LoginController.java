package com.example.fastfood_cart.controller.login;

import com.example.fastfood_cart.entity.User;
import com.example.fastfood_cart.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/view-login")
    public String viewLoginRegister(Model model) {
        model.addAttribute("user", new User());
        return "s";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        try {
            User user = userService.loginUser(email, password);
            if ("Admin".equals(user.getRole())) {
                session.setAttribute("loggedInUser", user);
                return "redirect:/admin";
            } else {
                session.setAttribute("loggedInUser", user);
                return "redirect:/admin";
            }
        } catch (RuntimeException e) {
            model.addAttribute("errorLogin", "Thông tin đăng nhập sai!");
            return "s";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam("passwordCF") String passwordCF, Model model) {
        if (!user.getPassword().equals(passwordCF)) {
            model.addAttribute("errorRegister", "Passwords không trùng khớp!");
            return "s";
        }
        if (bindingResult.hasErrors()) {
            return "s";
        }
        try {
            userService.dangKy(user.getUserName(), user.getEmail(), user.getPassword());
            return "redirect:/view-login";
        } catch (RuntimeException e) {
            model.addAttribute("errorRegister", e.getMessage());
            return "s";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "redirect:/view-login";
    }
}
