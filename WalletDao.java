package com.cg.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.project.bean.User;



@Repository
public interface WalletDao extends JpaRepository<User, String> {

	/*
	 * @Query("from user u where username:=uname") public User
	 * getUser(@Param("uname") String uname);
	 */
}
