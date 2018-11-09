//package com.stackroute.matchmaking.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.matchmaking.domain.User;
//import com.stackroute.matchmaking.service.UserService;
//import org.junit.Before;
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
//    @MockBean
//    private UserService userService;
//    @InjectMocks
//    private UserController userController;
//    private List<User> list = null;
//
//    @Before
//    public void setUp() {
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        user = new User();
//        user.setName("Hukma Ram");
//        user.setEmail("hukma@gmail.com");
//        user.setPassword("abcd1234");
//        list = new ArrayList();
//
//        list.add(user);
//    }
//    @Test
//    public void saveUser() throws Exception {
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/registration/ap1/v1/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//}