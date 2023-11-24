package th.mfu.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import th.mfu.dto.ContactUsDto;
import th.mfu.dto.UserDto;
import th.mfu.model.User;

public interface UserService {
    User save (UserDto userDto);

    User findByEmail(String email);

    User updateUserInfo(User currentUser, UserDto updateUser);

    boolean checkPassword(User currentUser, String currentPassword);

    boolean updatePassword(User currentUser, String currentPassword, String newPassword);

    void sentToMail(ContactUsDto contactUsDto) throws MessagingException, UnsupportedEncodingException;
}
