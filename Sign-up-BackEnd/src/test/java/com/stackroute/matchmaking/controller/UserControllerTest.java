//package com.stackroute.matchmaking.controller;
//
//
//import com.stackroute.matchmaking.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    private User user;
//        @MockBean
////    private UserService userService;
//    @InjectMocks
//    private UserController userController;
//    private List<User> list = null;
//
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        user = new User();
//        user.setEmail("hukma@gmail.com");
//        user.setName("Hukma Ram");
//        user.setPassword("abcd1234");
//        list = new ArrayList();
//
//        list.add(user);
//    }
//    public void saveUser() throws Exception {
//        when(true).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders.post("/registration/ap1/v1/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//}
