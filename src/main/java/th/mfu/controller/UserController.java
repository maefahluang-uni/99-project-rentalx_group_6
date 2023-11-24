package th.mfu.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.dto.ContactUsDto;
import th.mfu.dto.PasswordDto;
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
        
        // System.out.println("--------------------------------------------------------------------");
        // System.out.println(email);
        // System.out.println(userName);
        // System.out.println(password);
        // System.out.println(role);
        // System.out.println("--------------------------------------------------------------------");
       
        if(userRepository.findByEmail(email) == null){
            // userRepository.save(new User(email,password,role,userName));
            // System.out.println("--------------------------------------------------------------------");
            // System.out.println(email);
            // System.out.println(userName);
            // System.out.println(password);
            // System.out.println(role);
            // System.out.println("--------------------------------------------------------------------");
            UserDto userDto = new UserDto();
            userDto.setUserName(userName);
            userDto.setEmail(email);
            userDto.setRole(role);
            userDto.setPassword(passwordEncoder.encode(password));
            userService.save(userDto);
            // System.out.println("--------------------------------------------------------------------");
            // User user = userService.findByEmail(email);
            // System.out.println(user.getEmail());
            // System.out.println(user.getPassword());
            // System.out.println(user.getRole());
            // System.out.println(user.getUserName());
            // System.out.println("--------------------------------------------------------------------");

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

    @GetMapping("/update-profile")
    public String editNyl(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user",user);
        model.addAttribute("updateUser",new UserDto());
        return "update-profile";
    }

    @Transactional
    @PostMapping("/update-profile")
    public String saveProfile(@AuthenticationPrincipal UserDetails userDetails,
                              @ModelAttribute("updateUser") UserDto updateUser){
        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);
        userService.updateUserInfo(currentUser,updateUser);
        return "redirect:/update-profile";
    }


    @GetMapping("/change-password")
    public String changePassword(Model model){
        model.addAttribute("passwordDto",new PasswordDto());
        return "update-password";
    }
    @Transactional
    @PostMapping("/change-password")
    public String savePassword(@AuthenticationPrincipal UserDetails userDetails,
                               @ModelAttribute("passwordDto") PasswordDto passwordDto,
                               Model model){
        System.out.println("---------------------------------------------------------------");
        System.out.println(passwordDto.getCurrentPassword());
        System.out.println(passwordDto.getNewPassword());
        System.out.println(passwordDto.getConfirmPassword());
        System.out.println("---------------------------------------------------------------");

        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);
        if(passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())){
            System.out.println("passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()) = "+
                    passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()));
            System.out.println("currentPassword from Authentication " + currentUser.getPassword());
            System.out.println("currentPassword from Authentication " + passwordEncoder.encode(passwordDto.getCurrentPassword()));
            if(userService.checkPassword(currentUser,passwordDto.getCurrentPassword())){

                System.out.println("userService.checkPassword(currentUser,passwordDto.getCurrentPassword()) = "+
                        userService.checkPassword(currentUser,passwordDto.getCurrentPassword()));
                if (userService.updatePassword(currentUser,
                        passwordDto.getCurrentPassword(),
                        passwordDto.getNewPassword())){
                    model.addAttribute("successMessage", "Password updated successfully.");
                }
            }else{
                System.out.println("this is else ");
                //error message if current password is incorrect!
                model.addAttribute("errorMessage", "Current password is incorrect.");
            }
        }else{
            //error message if retyping password is incorrect!
            model.addAttribute("errorMessage", "Please type the same password with new password");
        }
        return "redirect:/change-password";
    }

    @GetMapping("/contactus")
    public String contactUs(Model model){
        model.addAttribute("contactus", new ContactUsDto());
        return "contact-us";
    }

    @PostMapping("/contactus")
    public String MailToTeam(@ModelAttribute("contactus") ContactUsDto contactUsDto){
        try {
            userService.sentToMail(contactUsDto);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "contact-us";
    }
}