package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import th.mfu.dto.DormDto;
import th.mfu.dto.ReviewDto;
import th.mfu.model.Dorm;
import th.mfu.model.User;
import th.mfu.service.DormService;
import th.mfu.service.ReviewService;
import th.mfu.service.UserService;
import th.mfu.service.WishListService;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
@Controller
public class DormController {

    @Autowired
    private UserService userService;

    @Autowired
    private DormService dormService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private WishListService wishlistService;

    @GetMapping("/dorms")
    public String dormList(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Long user_id = user.getId();
        model.addAttribute("dorms",dormService.getAllDorms());
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("wishlists", wishlistService.findByUserId(user_id));
        return "dorms";
    }

    @GetMapping("/dorms-wt")
    public String showDormsWithoutLogin(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "dorms-wt-login";
    }

    @PostMapping("/dorms/search")
    public String searchDorms(@RequestParam String keyword, Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("dorms", dormService.findByKeyword(keyword));
        return "dorms";
    }
    @GetMapping("/dorms/sort")
    public String sortDorms(@RequestParam("sortBy") String sortBy, Model model,@AuthenticationPrincipal UserDetails userDetails) {
        List<Dorm> sortedDorms;

        switch (sortBy) {
            case "priceLowToHigh":
                sortedDorms = dormService.getDormsSortedByPriceLowToHigh();
                break;
            case "priceHighToLow":
                sortedDorms = dormService.getDormsSortedByPriceHighToLow();
                break;
            case "nameAlphabetically":
                sortedDorms = dormService.getDormsSortedByNameAlphabetically();
                break;
            default:
                sortedDorms = (List<Dorm>) dormService.getAllDorms();
                break;
        }
        String email = userDetails.getUsername();
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("dorms", sortedDorms);
        return "dorms";
    }

    @GetMapping("/dorm/{id}")
    public String shoEachDorm(Model model,@PathVariable("id") Long dormId,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        model.addAttribute("user",userService.findByEmail(email));
        model.addAttribute("dorm",dormService.findById(dormId));
        model.addAttribute("review",new ReviewDto());
        model.addAttribute("reviewsInRepo",reviewService.findByDormId(dormId));
        return "show-each-dorm";
    }

    @GetMapping("/show-map")
    public String showMap(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "show-map";
    }

    @GetMapping("/landlord-dorms")
    public String showLandlordDorms(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User landlord = userService.findByEmail(email);
        Long landlordId = landlord.getId();
        model.addAttribute("dorms",dormService.findDormByLandlordId(landlordId));
        model.addAttribute("landlord", landlord);
        return "landlord-dorms";
    }

    @GetMapping("/create-dorm")
    public String showCreateDormForm(Model model,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User landlord = userService.findByEmail(email);
        model.addAttribute("dorm",new DormDto());
        model.addAttribute("landlord", landlord);
        return "create-dorm";
    }
    @PostMapping("/create-dorm")
    public String submitDorm(@ModelAttribute("dorm") DormDto dormDto,
                             @AuthenticationPrincipal UserDetails userDetails){
        
        String email = userDetails.getUsername();
        dormDto.setLandlord(userService.findByEmail(email));
        dormService.save(dormDto);

        return "redirect:/landlord-dorms";
        
    }

    @GetMapping("/updateDorm/{dorm_id}")
    public String updateDorm(Model model,@PathVariable("dorm_id") Long dormId,@AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User landlord = userService.findByEmail(email);
        model.addAttribute("dorm",dormService.findById(dormId));
        model.addAttribute("updatedDorm",new DormDto());
        model.addAttribute("landlord", landlord);
        return "update-dorm";
    }

    @PostMapping("/updateDorm/{dorm_id}")
    public String submitUpdatedDorm(Model model,@PathVariable("dorm_id") Long dormId,
                                    @ModelAttribute("updatedDorm") DormDto updateDorm){
        System.out.println("=======================================================================");
        System.out.println(updateDorm.getDormDesc());
        System.out.println(updateDorm.getCity());
        System.out.println(updateDorm.getAmenities());
        System.out.println("=======================================================================");
        dormService.updateDormInfo(dormService.findById(dormId),updateDorm);
        return "redirect:/landlord-dorms";
    }

    @Transactional
    @GetMapping("deleteDorm/{dorm_id}")
    public String deleteDorm(@PathVariable("dorm_id") Long dormId){
        wishlistService.deleteAllByDormId(dormId);
        reviewService.deleteByDormId(dormId);
        dormService.deleteDormById(dormId);
        return "redirect:/landlord-dorms";
    }
    
    @GetMapping("showPayment/{dorm_id}")
    public String showPayment(Model model,@PathVariable("dorm_id") Long dormId,
                                @AuthenticationPrincipal UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("dorm",dormService.findById(dormId));
        return "payment-page";
    }

    @GetMapping("/searchPage")
    public String searchPage(Model model){
        return "search-page";
    }
    
}