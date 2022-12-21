package com.exampl.service;

import com.exampl.model.SecurityUser;
import com.exampl.model.UserModel;
import com.exampl.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class ApplicationUserDetailService implements UserDetailsService {


    private final UserModelRepository userModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userModelRepository.findByMobileNumber(username).orElseThrow(() -> new RuntimeException("user not found"));
        System.out.println( user );
        return new SecurityUser(user);

    }
}
