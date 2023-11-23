package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.model.ForgotPasswordToken;

public interface ForgotPasswordRepository extends CrudRepository<ForgotPasswordToken,Long>{

    ForgotPasswordToken findByToken(String token);
    
}
