package com.themba.store.site.user;


import com.themba.store.site.auth.AuthenticationResponse;
import com.themba.store.site.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/register")
public class UserController {
    @GetMapping
    public String testing(){
        return "Rest Controller is working";
    }


    @GetMapping("/testing")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok("Testing");
    }

}
