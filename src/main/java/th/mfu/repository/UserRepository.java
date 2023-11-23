package th.mfu.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import th.mfu.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail (String email);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userName = :newUserName WHERE u.id = :userId")
    int updateUserName(@Param("userId") Long userId, @Param("newUserName") String newUserName);
    
    // @Modifying
    // @Query("UPDATE user u SET u.password=?3 WHERE u.id=?1 AND u.password=?2")
    // int updatePassword(Long userId, String currentPassword, String newPassword);
}