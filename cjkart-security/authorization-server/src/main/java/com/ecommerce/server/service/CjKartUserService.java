package com.ecommerce.server.service;

import com.ecommerce.server.repository.CjKartUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CjKartUserService implements UserDetailsService{

    @Autowired
    private  CjKartUserRepository cjKartUserRepository;

    public CjKartUserService(){
    }

    @Autowired
    public CjKartUserService(CjKartUserRepository cjKartUserRepository){
        this.cjKartUserRepository = cjKartUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.cjKartUserRepository.findByUserName(username)
                .map(u->new User(u.getUserName(), u.getPassword(),
                        u.isActive(), u.isActive(), u.isActive(), u.isActive(),
                        AuthorityUtils.createAuthorityList("ADMIN", "USER")))
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user: "+username));
    }
}
