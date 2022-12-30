package com.exampl.controller;

import com.exampl.model.UserModel;
import com.exampl.repository.UserModelRepository;
import com.exampl.service.ManageUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    private final UserModelRepository userModelRepository;
    private final PasswordEncoder encoder;

    @Autowired
    private ManageUserService manageUserService;



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(manageUserService.loginUser(loginDto.getMobileNumber() , loginDto.getPassword()));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registeruser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manageUserService.registerNewUser(userModel));
    }



}



@Getter @Setter
class LoginDto{

    private String mobileNumber;
    private String password;
}
