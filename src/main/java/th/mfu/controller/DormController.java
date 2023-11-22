package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.dto.ReviewDto;
import th.mfu.model.Dorm;
import th.mfu.service.DormService;
import th.mfu.service.UserService;
import java.util.List;
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
        // model.addAttribute("reviewsInRepo",reviewService.findByDormId(dormId));
        return "show-each-dorm";
    }

    @GetMapping("/show-map")
    public String showMap(Model model){
        model.addAttribute("dorms",dormService.getAllDorms());
        return "show-map";
    }
}