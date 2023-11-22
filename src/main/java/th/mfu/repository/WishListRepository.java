package th.mfu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.mfu.model.WishList;

@Repository
public interface WishListRepository extends CrudRepository<WishList,Long>{

    @Query(value = "Select * from wishlist where user_id=?1",nativeQuery = true)
    List<WishList> findAllByUserId(Long userId);
    
}
