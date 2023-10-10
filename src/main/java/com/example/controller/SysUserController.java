package com.example.controller;

import com.example.entity.SysUserRequest;
import com.example.entity.SysUserResponse;
import com.example.service.SysUserService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SysUserController {
	
	@Autowired
    private SysUserService sysUserService;

	// create user
    @PostMapping("/users")
    public ResponseEntity<SysUserResponse> createSysUser(@Valid @RequestBody SysUserRequest request) {
        SysUserResponse sysUserResponse = sysUserService.createSysUser(request);

        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(sysUserResponse.getId())
        		.toUri();

        return ResponseEntity.created(location).body(sysUserResponse);
    }

    // read user
    @GetMapping("/users/{id}")
    public ResponseEntity<SysUserResponse> readSysUser(@PathVariable("id") String id) {
        SysUserResponse sysUserResponse = sysUserService.getUserById(id);
        return ResponseEntity.ok(sysUserResponse);
    }

    // read all users
    @GetMapping("/users")
    public ResponseEntity<List<SysUserResponse>> readSysUsers() {
        List<SysUserResponse> sysUserResponses = sysUserService.readSysUsers();
        return ResponseEntity.ok(sysUserResponses);
    }
    
    // update user
    @PutMapping("/users/{id}")
	public ResponseEntity<SysUserResponse> updateSysUser(@PathVariable("id") String id, @Valid @RequestBody SysUserRequest request) {
		SysUserResponse sysUserResponse = sysUserService.updateSysUser(id, request);
        return ResponseEntity.ok().body(sysUserResponse);
	}

}
