package th.mfu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import th.mfu.dto.UserDto;
import th.mfu.model.User;
import th.mfu.repository.UserRepository;
import th.mfu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private Long userId = 7L;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userId,userDto.getEmail(), userDto.getPassword(), userDto.getRole(), userDto.getUserName());
        userId++;
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return  user;
    }

    @Override
    public User updateUserInfo(User currentUser, UserDto updateUser) {
        if(updateUser.getUserName() != null){
            int roleaffected = userRepository.updateUserName(currentUser.getId(), updateUser.getUserName());
            if(roleaffected > 0){
                currentUser.setUserName(updateUser.getUserName());
            }else{
                System.out.println("error");
            }
            
        }
        return currentUser;
    }

    @Override
    public boolean checkPassword(User currentUser, String currentPassword) {
        return passwordEncoder.matches(currentPassword, currentUser.getPassword());
    }

    @Override
    public boolean updatePassword(User currentUser, String currentPassword, String newPassword) {
        int rowsAffected = userRepository.updatePassword(currentUser.getId(), passwordEncoder.encode(currentPassword), passwordEncoder.encode(newPassword));
        currentUser.setPassword(passwordEncoder.encode(newPassword));
        return rowsAffected > 0;
    }
}
