package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.mfu.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long>{
    
}
