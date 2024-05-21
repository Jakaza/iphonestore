package com.themba.store.site.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final int PAGESIZE = 10;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>>  getUsers(){
        return findPagination(1);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String search){
        List<User> users = userService.findUserByNameOrSurnameOrEmail(search);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/page/{pageNumber}")
    @PreAuthorize("hasRole('ADMIN')")
    private ResponseEntity<List<User>> findPagination(@PathVariable("pageNumber") int currentPage){
        Pageable pageable = PageRequest.of(currentPage - 1, PAGESIZE);
        Page<User> page = userService.findAllPageable(pageable);
        int totalPage = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<User> users = page.getContent();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/update")
    public ResponseEntity<User> update(@RequestBody String firstName,
                                       @RequestBody String lastName,
                                       @RequestParam MultipartFile avator,
                                       @RequestBody String phoneNumber){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User newUserDetails = userService.update( currentUserName ,firstName, lastName ,avator ,phoneNumber );
        return ResponseEntity.ok(newUserDetails);
    }
}
