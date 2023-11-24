package th.mfu.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import th.mfu.model.Dorm;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DormRepository extends CrudRepository<Dorm,Long> {
    @Query(value = "Select * from dorm where landlord_id=?1",nativeQuery = true)
    List<Dorm> findDormsByLandlordId(Long landlordId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE dorm SET " +
            "dormName = COALESCE(?2, dormName), " +
            "dormDesc = COALESCE(?3, dormDesc), " +
            "price = COALESCE(?4, price), " +
            "img1 = COALESCE(?5, img1), " +
            "img2 = COALESCE(?6, img2), " +
            "img3 = COALESCE(?7, img3), " +
            "img4 = COALESCE(?8, img4), " +
            "bedroom = COALESCE(?9, bedroom), " +
            "bathroom = COALESCE(?10, bathroom), " +
            "city = COALESCE(?11, city), " +
            "amenities = COALESCE(?12, amenities), " +
            "latitude = COALESCE(?13, latitude), " +
            "longitude = COALESCE(?14, longitude) " +
            "WHERE dormId = ?1", nativeQuery = true)
    void updateDorm(Long originalDormId, String dormName, String dormDesc, Integer price,String img1,String img2,String img3,String img4,
                 Integer bedroom,Integer bathroom, String city, String amenities, Double latitude, Double longitude);
}
