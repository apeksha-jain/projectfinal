package com.cg.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.project.bean.AccountTransactions;

public interface TransactionDao extends JpaRepository<AccountTransactions, Integer>{

	/*
	 * @Query("select t.transaction from AccountTransactions t where t.username:=userid"
	 * ) public List<String>getTransaction(@Param("userid") String userid);
	 */
}
