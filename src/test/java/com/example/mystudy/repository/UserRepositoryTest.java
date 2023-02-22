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

import static org.junit.jupiter.api.Assertions.*;

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
                .account("test01")
                .password("Test01")
                .status("REGISTERED")
                .email("Test01@naver.com")
                .phoneNumber("010-2222-3333")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .build();
        User newUser = userRepository.save(user);
        assertNotNull(newUser);
    }

    /*@DisplayName("Read 테스트")
    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findByAccount("test04");

        user.ifPresent(selectUser -> {
           selectUser.getOrderDetailList().stream().forEach(detail ->{
               System.out.println(detail.getItemId());
           });
        });
    }*/
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
        Optional<User> user = userRepository.findById(4L);

        assertTrue(user.isPresent());
        user.ifPresent(selectUser->{ userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);

        assertFalse(deleteUser.isPresent());
    }
}