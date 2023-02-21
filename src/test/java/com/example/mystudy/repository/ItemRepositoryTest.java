package com.example.mystudy.repository;

import com.example.mystudy.MystudyApplication;
import com.example.mystudy.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = MystudyApplication.class)
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = Item.builder()
                .name("노트북")
                .price(9000)
                .content("삼성노트북")
                .build();

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);

    } @Test
    public void read(){

    }
}