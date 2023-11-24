package th.mfu.service;

import java.util.List;

import th.mfu.dto.WishListDto;
import th.mfu.model.WishList;

public interface WishListService {

    List<WishList> findByUserId(Long userId);

    WishList findByUserIdAndDormId(Long userId, Long dorm_id);

    WishList save(WishListDto wishListDto);

    void deleteFromWishList(Long userId, Long dorm_id);

    void deleteAllByDormId(Long dormId);
    
}
