package com.example.workoutTracker.web;

import com.example.workoutTracker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userDetailServiceImpl implements UserDetailsService {
    private final userRepository uRepository;

    @Autowired
    public userDetailServiceImpl(userRepository uRepository) {
        this.uRepository = uRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User curruser = uRepository.findByUserName(username);
        UserDetails User = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return User;
    }
}
