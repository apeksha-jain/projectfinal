package com.cg.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.bean.AccountTransactions;
import com.cg.project.bean.User;
import com.cg.project.dao.TransactionDao;
import com.cg.project.dao.WalletDao;


@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletDao walletdao; 
	
	@Autowired
	TransactionDao td;
	@Override
	public void createAccount(User user) {
		walletdao.save(user);
	}

	@Override
	public String getUser(String uname) {
		
		User u = walletdao.findById(uname).get();
		if(walletdao.findById(uname).isPresent())
		{
			return u.getPassword();
		}
		else {
			return null;
		}
	}
	@Override
	public User getUserById(String username) {
		return walletdao.findById(username).get();
	}

	@Override
	public void depositAmount(User user) {
		 walletdao.save(user);
		
	}

	@Override
	public void withdrawAmount(User user) {
		walletdao.save(user);
		
	}

	@Override
	public void fundTransfer(User user) {
		// TODO Auto-generated method stub
		walletdao.save(user);
	}

	@Override
	public void saveTransaction(AccountTransactions transaction) {
		
		td.save(transaction);
	}

	/*
	 * @Override public List<String> getAllTransactions(String userid) {
	 * 
	 * return td.getTransaction(userid); }
	 */

	
	

}
