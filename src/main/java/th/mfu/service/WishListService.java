package th.mfu.service;

import java.util.List;

import th.mfu.model.WishList;

public interface WishListService {

    List<WishList> findByUserId(Long userId);
    
}
