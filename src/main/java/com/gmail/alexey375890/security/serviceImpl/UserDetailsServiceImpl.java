package com.gmail.alexey375890.security.serviceImpl;

import com.gmail.alexey375890.model.WmUsers;
import com.gmail.alexey375890.repository.WmUsersRepository;
import com.gmail.alexey375890.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final WmUsersRepository wmUsersRepository;

    @Autowired
    public UserDetailsServiceImpl(WmUsersRepository wmUsersRepository) {
        this.wmUsersRepository = wmUsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WmUsers user = wmUsersRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));

        return SecurityUser.fromUser(user);
    }
}
