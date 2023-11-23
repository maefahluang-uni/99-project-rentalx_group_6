package th.mfu.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import th.mfu.dto.WishListDto;
import th.mfu.model.User;
import th.mfu.service.DormService;
import th.mfu.service.UserService;
import th.mfu.service.WishListService;

@Controller
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private UserService userService;

    @Autowired
    private DormService dormService;
    
    private int nextId = 3;
    @GetMapping("/wishlists")
    public String showWishList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        System.out.println(userId);
        
        model.addAttribute("wishlists",wishListService.findByUserId(userId));
        model.addAttribute("user", user);
        return "wishlist";
    }

    @Transactional
    @GetMapping("/add-wishList/{dorm_id}")
    public String pushToWishList(@PathVariable("dorm_id") Long dorm_id,
                                 @AuthenticationPrincipal UserDetails userDetails){

        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long userId = user.getId();
        System.out.println("============================================================");
        System.out.println("userId: "+userId);
        System.out.println("email"+email);
        System.out.println("============================================================");
        if(wishListService.findByUserIdAndDormId(userId,dorm_id) == null){
            System.out.println("============================================================");

            System.out.println("============================================================");
            WishListDto wishListDto = new WishListDto(user, dormService.findById(dorm_id));
            wishListService.save(wishListDto);
            return "redirect:/dorms";
        }else{
            wishListService.deleteFromWishList(userId,dorm_id);
            return "redirect:/dorms";
        }
    }
}
