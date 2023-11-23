package th.mfu.service.Impl;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import th.mfu.dto.ForgotPasswordTokenDto;
import th.mfu.model.ForgotPasswordToken;
import th.mfu.repository.ForgotPasswordRepository;
import th.mfu.service.ForgotPasswordService;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService{

    private final int MINUTES = 10;
    private Long id = 1L;
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;

    @Override
    public LocalDateTime expiredTimeRange() {
        return LocalDateTime.now().plusMinutes(MINUTES);
    }

    @Override
    public String generatedToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public ForgotPasswordToken save(ForgotPasswordTokenDto forgotPasswordTokenDto) {
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken(id,forgotPasswordTokenDto.getToken(),forgotPasswordTokenDto.getUser(),forgotPasswordTokenDto.getExpiredTime(),forgotPasswordTokenDto.isUsed());
        id++;
        return forgotPasswordRepository.save(forgotPasswordToken);
    }

    @Override
    public void sendEmail(String toEmail, String subject, String emailLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String emailContent = "<p>Hello</p>"
                + "Click the link the below to reset password"
                + "<p><a href=\""+ emailLink + "\">Change My Password</a></p>"
                + "<br>"
                + "Ignore this Email if you did not made the request";
        helper.setText(emailContent, true);
        helper.setFrom("zarnn872@gmail.com", "RentalX customer Support");
        helper.setSubject(subject);
        helper.setTo(toEmail);
        javaMailSender.send(message);
    }

    public boolean isExpired (ForgotPasswordToken forgotPasswordToken) {
		return LocalDateTime.now().isAfter(forgotPasswordToken.getExpiredTime());
	}

    @Override
    public String checkValidity(ForgotPasswordToken forgotPasswordToken, Model model) {
        if (forgotPasswordToken == null) {
			model.addAttribute("error", "Invalid Token");
			return "error-page";
		}
		
		else if (forgotPasswordToken.isUsed()) {
			model.addAttribute("error", "the token is already used");
			return "error-page";
		}
		
		else if (isExpired(forgotPasswordToken)) {
			model.addAttribute("error", "the token is expired");
			return "error-page";
		}
		else {
			return "reset-password";
		}
    }

    @Override
    public ForgotPasswordToken findByToken(String token) {
        return forgotPasswordRepository.findByToken(token);
    }

    
}
