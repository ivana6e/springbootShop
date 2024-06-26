package com.example.security;

/*
import com.example.entity.SysUser;
import com.example.exception.NotFound;
import com.example.service.SysUserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// sign in
@Service
*/
public class UserDetailsServiceImpl /* implements UserDetailsService */{
	
	/* @Autowired
	private SysUserService sysUserService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			SysUser sysUser = sysUserService.getUserByEmail(email);
	        List<SimpleGrantedAuthority> authorities = sysUser.getAuthorities().stream()
	                .map(auth -> new SimpleGrantedAuthority(auth.name()))
	                .collect(Collectors.toList());

	        return new User(sysUser.getEmailAddress(), sysUser.getPassword(), authorities);
	        
        } catch (NotFound e) {
            throw new UsernameNotFoundException("Username is wrong.");
        }
    }
    */

}
