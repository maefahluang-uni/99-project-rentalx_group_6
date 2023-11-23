package th.mfu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.mfu.model.WishList;

@Repository
public interface WishListRepository extends CrudRepository<WishList,Long>{

    @Query(value = "Select * from wishlist where user_id=?1",nativeQuery = true)
    List<WishList> findAllByUserId(Long userId);
    
    @Query(value = "Select * from wishlist where user_id=?1 and dorm_id=?2",nativeQuery = true)
    WishList findByUserIdAndDormId(Long userId, Long dormId);

    @Modifying
    @Query(value = "DELETE from wishlist where user_id=?1 and dorm_id=?2",nativeQuery = true)
    int deleteWishListByUserIdAndDormId(Long userId, Long dormId);
}
