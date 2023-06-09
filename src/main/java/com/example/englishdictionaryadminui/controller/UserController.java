package com.example.englishdictionaryadminui.controller;

import com.example.englishdictionaryadminui.models.User;
import com.example.englishdictionaryadminui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String users(
            Model model
    )
    {
        if(userService.getAllUser().getStatusCode().is2xxSuccessful())
        {
            List<User> list = userService.getAllUser().getBody();
            model.addAttribute("users",list);
            return "user/users";
        } else {
            return "error/500";
        }
    }
    @GetMapping("/edit/{id}")
    public String editUser(
            Model model,
            @RequestParam("id") String id
    )
    {
        if (userService.getUserById(id).getStatusCode().is2xxSuccessful())
        {
            User user = userService.getUserById(id).getBody();
            model.addAttribute("user",user);
            return "user/editUser";
        } else {
            return "error/404";
        }
    }

    @GetMapping("/disable/{id}")
    public String disableUser(
            Model model,
            @PathVariable("id") String id
    )
    {
        if (userService.getUserById(id).getStatusCode().is2xxSuccessful()
                && userService.disableUserById(id).getStatusCode().is2xxSuccessful())
        {
            return "redirect:/user/users";
        } else {
            return "error/404";
        }
    }

}
