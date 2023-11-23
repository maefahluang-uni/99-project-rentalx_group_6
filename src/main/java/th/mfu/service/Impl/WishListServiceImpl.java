package th.mfu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.dto.WishListDto;
import th.mfu.model.WishList;
import th.mfu.repository.WishListRepository;
import th.mfu.service.WishListService;

@Service
public class WishListServiceImpl implements WishListService{

    private Long wishlistId = 3L;
    @Autowired
    private WishListRepository wishListRepository;

    @Override
    public List<WishList> findByUserId(Long userId) {
        return wishListRepository.findAllByUserId(userId);
    }

    @Override
    public WishList findByUserIdAndDormId(Long userId, Long dorm_id) {
        return wishListRepository.findByUserIdAndDormId(userId,dorm_id);
    }

    @Override
    public WishList save(WishListDto wishListDto) {
        WishList wishList = new WishList(wishlistId,wishListDto.getUser(),wishListDto.getDorm());
        wishlistId++;
        return wishListRepository.save(wishList);
    }

    @Override
    public void deleteFromWishList(Long userId, Long dorm_id) {
        int rowsAffected = wishListRepository.deleteWishListByUserIdAndDormId(userId, dorm_id);
        if (rowsAffected > 0) {
            System.out.println("delete successfully!");
        } else {
            // Handle the case where the row was not found or deleted
            // You can throw an exception or handle it according to your application logic
            System.out.println("error");
        }
    }
    
}
