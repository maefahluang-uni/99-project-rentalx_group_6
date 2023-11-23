package th.mfu.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.ui.Model;

import th.mfu.dto.ForgotPasswordTokenDto;
import th.mfu.model.ForgotPasswordToken;

public interface ForgotPasswordService {

    LocalDateTime expiredTimeRange();

    String generatedToken();

    ForgotPasswordToken save(ForgotPasswordTokenDto forgotPasswordTokenDto);

    void sendEmail(String email, String string, String emailLink) throws MessagingException, UnsupportedEncodingException;

    String checkValidity(ForgotPasswordToken forgotPasswordToken, Model model);

    ForgotPasswordToken findByToken(String token);
    
}
