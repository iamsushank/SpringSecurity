package com.exampl.service;

import com.exampl.model.Role;
import com.exampl.model.RoleEnum;
import com.exampl.model.UserModel;
import com.exampl.repository.RoleRepository;
import com.exampl.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManageUserService{

    
    private final UserModelRepository userModelRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;




    
    @Autowired
    public ManageUserService(UserModelRepository userRepo , RoleRepository roleRepo) {
        
        this.userModelRepository = userRepo;
        this.roleRepository = roleRepo;
    }

    public String registerNewUser(UserModel user) {

        if(userModelRepository.existsByMobileNumber(user.getMobileNumber())) {

            throw new RuntimeException("This mobile number is already there");
        }
//
//        Role role = roleRepository.findByRole("ROLE_USER").orElseThrow(() -> new RuntimeException("role not is present"));


        Role role=  new Role();
        role.setId(1);
        role.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);

        userModelRepository.save(user);
        return "user registered successfully";
    }

    public String loginUser(String mobileNumber , String password) {


        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobileNumber , password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "login successfully";
    }

}
