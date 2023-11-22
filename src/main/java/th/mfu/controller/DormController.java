package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import th.mfu.service.DormService;
import th.mfu.service.UserService;

@Controller
public class DormController {

    @Autowired
    private UserService userService;

    @Autowired
    private DormService dormService;

    @GetMapping("/dorms")
    public String dormList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("dorms",dormService.getAllDorms());
        model.addAttribute("user",userService.findByEmail(email));
        return "dorms";
    }
}