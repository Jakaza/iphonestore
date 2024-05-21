package com.themba.store.site.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/testing")
    public String testing(){
        return "Rest Controller is working";
    }






}
