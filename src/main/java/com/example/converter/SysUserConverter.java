package com.example.converter;

import com.example.entity.SysUser;
import com.example.entity.SysUserRequest;
import com.example.entity.SysUserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class SysUserConverter {
	
	// user request to database document(user)
	public static SysUser toSysUser(SysUserRequest request) {
        SysUser sysUser = new SysUser();
        sysUser.setId(request.getId()); //
        sysUser.setName(request.getName());
        sysUser.setEmailAddress(request.getEmailAddress());
        sysUser.setPassword(request.getPassword());
        sysUser.setAuthorities(request.getAuthorities());

        return sysUser;
    }

	// database document(user) to user response
    public static SysUserResponse toSysUserResponse(SysUser sysUser) {
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setName(sysUser.getName());
        sysUserResponse.setEmailAddress(sysUser.getEmailAddress());
        sysUserResponse.setAuthorities(sysUser.getAuthorities());

        return sysUserResponse;
    }

    public static List<SysUserResponse> toSysUserResponses(List<SysUser> sysUsers) {
        return sysUsers.stream()
                .map(SysUserConverter::toSysUserResponse)
                .collect(Collectors.toList());
    }

}
