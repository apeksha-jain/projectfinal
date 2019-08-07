package com.cg.project.service;

import java.util.List;

import com.cg.project.bean.AccountTransactions;
import com.cg.project.bean.User;

public interface WalletService {

	public void createAccount(User user);
	public String getUser(String uname);
	public User getUserById(String username);
	public void depositAmount(User user);
	public void withdrawAmount(User user);
	public void fundTransfer(User user);
	public void saveTransaction(AccountTransactions transaction);
	/* public List<String> getAllTransactions(String userid); */
}
