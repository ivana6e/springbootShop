package com.example.repository;

import com.example.entity.SysUser;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUserRepository extends MongoRepository<SysUser, String> {
	
	Optional<SysUser> findByEmailAddress(String email);

}
