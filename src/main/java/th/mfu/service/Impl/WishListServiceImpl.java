package th.mfu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.model.WishList;
import th.mfu.repository.WishListRepository;
import th.mfu.service.WishListService;

@Service
public class WishListServiceImpl implements WishListService{
    @Autowired
    private WishListRepository wishListRepository;

    @Override
    public List<WishList> findByUserId(Long userId) {
        return wishListRepository.findAllByUserId(userId);
    }
    
}
