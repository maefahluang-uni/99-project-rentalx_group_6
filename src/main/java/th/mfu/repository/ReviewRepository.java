package th.mfu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.mfu.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long>{
    
    @Query(value = "Select * from review where dorm_id=?1",nativeQuery = true)
    List<Review> findByDormId(Long dormId);

    @Modifying
    @Query("DELETE FROM Review r WHERE r.dorm.dormId = :dormId")
    void deleteByDormId(@Param("dormId") Long dormId);
}
