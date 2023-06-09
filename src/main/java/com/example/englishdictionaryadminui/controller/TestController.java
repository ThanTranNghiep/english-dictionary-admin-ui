package com.example.englishdictionaryadminui.controller;

import com.example.englishdictionaryadminui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @Autowired
    UserService userService;
//    @GetMapping("/test")
//    @ResponseBody
//    public String test()
//    {
//        Map<String,String> gender = userService.getAllGender().getBody();
//        ResponseEntity<String> response = userService.deleteUserById("lele");
//        System.out.println(response.getStatusCode().value());
//        if (response.getStatusCode().is2xxSuccessful()) {
//            return response.getStatusCode().value() + "---> được nhó";
//        }
//        else
//        {
//            return "error con mẹ nó rồi";
//        }
//    }
}
