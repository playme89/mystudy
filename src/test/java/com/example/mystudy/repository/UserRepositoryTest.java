package com.example.mystudy.repository;

import com.example.mystudy.MystudyApplication;
import com.example.mystudy.model.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = User.builder()
                .account("test03")
                .email("playme3@naver.com")
                .phoneNumber("010-1111-1111")
                .createdAt(LocalDateTime.now())
                .createdBy("admin3")
                .build();
        User newUser = userRepository.save(user);
        System.out.println("newUser:"+ newUser);
    }

    @Test
    public void read(@RequestParam Long id) {
       Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser->{
            System.out.println("user:" + selectUser);
            System.out.println("email:"+ selectUser.getEmail());
        });

    }

    public void update() {

    }

    public void delete() {

    }
}