package com.example.entity;

import java.util.List;

public class SysUserResponse {
	
	private String id;
	private String name;
    private String emailAddress;
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
    
    public void setAuthorities(List<SysUserAuthority> authorities) {
        this.authorities = authorities;
    }
    
    public List<SysUserAuthority> getAuthorities() {
        return authorities;
    }
    
}
