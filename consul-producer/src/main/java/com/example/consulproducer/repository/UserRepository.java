package com.example.consulproducer.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.consulproducer.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>{
	@Query(value = "select e.userId from UserEntity e where e.username=:username ")
	Integer findUserIdByUsername(@Param("username")String username);
	List<UserEntity> findByAddressByCreatedateDesc(String address);
	
	@Query(value = "select e.userId from UserEntity e where e.username in (:usernames) and e.validFlag=:validFlag")
	Set<Integer> findUserIdByUsernamesInAndValidFlag(@Param("usernames") Set<String> usernames, @Param("validFlag") Integer validFlag);

}
