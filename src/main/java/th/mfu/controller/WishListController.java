package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import th.mfu.model.User;
import th.mfu.model.WishList;
import th.mfu.service.UserService;
import th.mfu.service.WishListService;

@Controller
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/wishlists")
    public String showWishList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        System.out.println(userId);
        
        model.addAttribute("wishlists",wishListService.findByUserId(userId));
        return "wishlist";
    }
}
