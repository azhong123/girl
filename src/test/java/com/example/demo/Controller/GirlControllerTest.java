package com.example.demo.Controller;

import com.example.demo.domain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * 测试
 * Created by Admin on 2017/11/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllGirl() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jap/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findGirlByAgeAndException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/jap/findgirlbyage/5"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
