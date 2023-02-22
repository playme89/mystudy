package com.example.mystudy.repository;


import com.example.mystudy.MystudyApplication;
import com.example.mystudy.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = MystudyApplication.class)
public class PartnerRepositoryTest {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = Partner.builder()
                .name("Partner01")
                .status("REGISTERED")
                .address("서울시 강남구")
                .callCenter("070-1111-2222")
                .partnerNumber("010-1111-2222")
                .businessNumber("123456123")
                .ceoName("홍길동")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .categoryId(1)
                .build();

        Partner newPartner = partnerRepository.save(partner);
        assertNotNull(newPartner);
        assertEquals(newPartner.getName(), partner.getName());
    }
    public void read(){

    }
}
