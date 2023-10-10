package com.example.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class SysUserRequest {
	
	@NotBlank
	private String id;
	
	@NotBlank
    private String name;
	
	@NotBlank
	@Email
    private String emailAddress;
	
    @NotBlank
    private String password;
    
    
    private List<SysUserAuthority> authorities;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setAuthorities(List<SysUserAuthority> authorities) {
        this.authorities = authorities;
    }
    
    public List<SysUserAuthority> getAuthorities() {
        return authorities;
    }

}
