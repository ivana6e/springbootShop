package com.example.service;

import com.example.converter.SysUserConverter;
import com.example.entity.SysUser;
import com.example.entity.SysUserRequest;
import com.example.entity.SysUserResponse;
import com.example.exception.*;
import com.example.repository.SysUserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;

    // create user
    public SysUserResponse createSysUser(SysUserRequest request) {
        Optional<SysUser> existingUser = sysUserRepository.findByEmailAddress(request.getEmailAddress());
        if(existingUser.isPresent()) {
            throw new UnprocessableEntity("This email address has been used.");
        }

        SysUser sysUser = SysUserConverter.toSysUser(request);
        sysUser = sysUserRepository.insert(sysUser);
        return SysUserConverter.toSysUserResponse(sysUser);
    }
    
    // read user email
    public SysUser getUserByEmail(String email) {
        return sysUserRepository.findByEmailAddress(email)
                .orElseThrow(() -> new NotFound("Can't find user."));
    }

    // read user id
    public SysUserResponse getUserById(String id) {
        SysUser sysUser = sysUserRepository.findById(id)
        		 .orElseThrow(() -> new NotFound("Can't find user."));
        return SysUserConverter.toSysUserResponse(sysUser);
    }

    // read all users
    public List<SysUserResponse> readSysUsers() {
        List<SysUser> sysUsers = sysUserRepository.findAll();
        return SysUserConverter.toSysUserResponses(sysUsers);
    }
    
    // update user
    public SysUserResponse updateSysUser(String id, SysUserRequest request) {
    	SysUser oldSysUser = sysUserRepository.findById(id)
       		 .orElseThrow(() -> new NotFound("Can't find user."));
        SysUser newSysUser = SysUserConverter.toSysUser(request);
        newSysUser.setId(oldSysUser.getId());
        sysUserRepository.save(newSysUser);

        return SysUserConverter.toSysUserResponse(newSysUser);
    }

}
