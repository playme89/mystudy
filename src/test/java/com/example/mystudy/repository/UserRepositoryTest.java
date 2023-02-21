package com.example.mystudy.repository;


import com.example.mystudy.MystudyApplication;
import com.example.mystudy.model.entity.User;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = MystudyApplication.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("Create 테스트")
    @Test
    public void create() {
        User user = User.builder()
                .account("test04")
                .email("playme4@naver.com")
                .phoneNumber("010-1111-1111")
                .createdAt(LocalDateTime.now())
                .createdBy("admin4")
                .build();
        User newUser = userRepository.save(user);
        System.out.println("newUser:" + newUser);
    }

    @DisplayName("Read 테스트")
    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user:" + selectUser);
            System.out.println("email:" + selectUser.getEmail());
        });
    }
    @DisplayName("Update 테스트")
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent( selectUser->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method");

            userRepository.save(selectUser);
        });



    }
    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());
        user.ifPresent(selectUser->{ userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());
    }
}