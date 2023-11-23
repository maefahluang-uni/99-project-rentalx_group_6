package th.mfu.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.dto.UserDto;
import th.mfu.model.User;
import th.mfu.repository.UserRepository;
import th.mfu.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {

        return "signup";
    }

    @PostMapping("/registration")
    public String saveUser( @RequestParam String userName,
    @RequestParam String email,
    @RequestParam String password,
    @RequestParam String role) {
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println(email);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(role);
        System.out.println("--------------------------------------------------------------------");
       
        if(userRepository.findByEmail(email) == null){
            // userRepository.save(new User(email,password,role,userName));
            System.out.println("--------------------------------------------------------------------");
            System.out.println(email);
            System.out.println(userName);
            System.out.println(password);
            System.out.println(role);
            System.out.println("--------------------------------------------------------------------");
            UserDto userDto = new UserDto();
            userDto.setUserName(userName);
            userDto.setEmail(email);
            userDto.setRole(role);
            userDto.setPassword(passwordEncoder.encode(password));
            userService.save(userDto);
             System.out.println("--------------------------------------------------------------------");
            User user = userService.findByEmail(email);
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getRole());
            System.out.println(user.getUserName());
            System.out.println("--------------------------------------------------------------------");

            return "redirect:/login";
        }else{
            return "redirect:/signup";
        }
        // model.addAttribute("message", "Registered Successfully!");
        
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }

    @GetMapping("/profile")
    public String showProfileNyl(@AuthenticationPrincipal UserDetails userDetails,Model model){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user",user);
        return "profile";
    }
}