package com.example.fastfood_cart.service;

import com.example.fastfood_cart.entity.User;
import com.example.fastfood_cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public User dangKy(@NotEmpty String userName, @Email String email, @NotEmpty String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email đã tồn tại!");
        }
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("Khach");
        return userRepository.save(user);
    }
    public User loginUser(@Email String email, @NotEmpty String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) { // So sánh mật khẩu plain text
                return user;
            } else {
                throw new RuntimeException("Thông tin đăng nhập sai!");
            }
        } else {
            throw new RuntimeException("Tài khoản không tồn tại!");
        }
    }
}
