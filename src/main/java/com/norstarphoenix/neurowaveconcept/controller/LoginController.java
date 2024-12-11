//package com.norstarphoenix.neurowaveconcept.controller;
//
//import com.norstarphoenix.neurowaveconcept.models.User;
//import com.norstarphoenix.neurowaveconcept.services.UserServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class LoginController {
//
//    private final UserServices userService;
//
//    // Constructor-based dependency injection
//    @Autowired
//    public LoginController(UserServices userService) {
//        this.userService = userService;
//    }
//
//    // Mapping for the login page
//    @GetMapping("/login")
//    public String showLoginPage(Model model) {
//        model.addAttribute("user", new User());
//        return "login"; // Refers to login.html in src/main/resources/templates
//    }
//
//    // Mapping to handle login form submission
//    @PostMapping("/login")
//    public String processLogin(@ModelAttribute User user, Model model) {
//        // Authenticate the user using the service instance
//        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());
//        if (isAuthenticated) {
//            return "redirect:/dashboard"; // Redirect to dashboard on successful login
//        }
//        model.addAttribute("error", "Invalid username or password");
//        return "login"; // Show login page with error message
//    }
//}
