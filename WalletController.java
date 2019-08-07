package com.cg.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.project.bean.AccountTransactions;
import com.cg.project.bean.User;
import com.cg.project.dao.TransactionDao;
import com.cg.project.service.WalletService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WalletController {

	
	@Autowired
	WalletService walletservice;
	
	List<String> transaction = new ArrayList<String>();
	  @PostMapping(path = "/api/create-account")
	  public int createAccount( @RequestBody User user) {
	  System.out.println("in spring"); 
	  walletservice.createAccount(user); 
	  return 1; 
	  }
	  
	  @GetMapping("/api/check")
	  public void check()
	  {
		  System.out.println("in void");
	  }
	  @GetMapping(path="/api/{username}/{password}")
	  public boolean validateUser(@PathVariable String username, @PathVariable String password)
	  {
		  System.out.println("in get");
		  if(password.equals(walletservice.getUser(username)))
		  {
			  System.out.println("password match");
			  return true;
		  }
		  else {
			  System.out.println("password not match");
			  return false;
		  }
	  }
	  
	  @GetMapping(path="/api/show-balance/{userid}")
	  public String showBalance(@PathVariable String userid)
	  {
		  System.out.println("In show balance");
		  Integer amount;
		  User u = walletservice.getUserById(userid);
		  amount=u.getCurrentbalance();
		  return amount.toString();
	  }
	  
	  @PutMapping("/api/deposit/{id}")
		public String depositAmount(@PathVariable String id,@RequestBody int depositamount)
		{
			AccountTransactions at=new AccountTransactions();
			User user = walletservice.getUserById(id);
			user.setCurrentbalance(user.getCurrentbalance()+depositamount);
			walletservice.depositAmount(user);
			at.setUsername(id);
			at.setTransaction(depositamount+" "+"was successfully deposited");
			walletservice.saveTransaction(at);
			return "Amount has been successfully deposited";
		}
	  
	  @PutMapping("/api/withdraw/{id}")
		public String withdrawAmount(@PathVariable String id,@RequestBody int withdrawamount)
		{
		  AccountTransactions at=new AccountTransactions();
			User u = walletservice.getUserById(id);
			if(u.getCurrentbalance()>withdrawamount)
			{
				u.setCurrentbalance(u.getCurrentbalance()-withdrawamount);
				walletservice.withdrawAmount(u);
				at.setUsername(id);
				at.setTransaction(withdrawamount+" "+"has been withdrawn successfully");
				walletservice.saveTransaction(at);
				return "Amount has been withdrawn successfully";
			}
			else 
			{
				return "Insufficient Balance";
			}
		}
	  
	  @PutMapping("api/fund-transfer/{id}")
		public String tansferFund(@PathVariable String id,@RequestBody int fund)
		{
		  AccountTransactions at=new AccountTransactions();
			User user = walletservice.getUserById(id);
			if(user.getCurrentbalance()>fund)
			{
				
				user.setCurrentbalance(user.getCurrentbalance()-fund);
				walletservice.fundTransfer(user);
				at.setUsername(id);
				at.setTransaction(fund+" "+"were successfully transfered to xyz");
				walletservice.saveTransaction(at);
			/* transaction.add(fund+" "+"were successfully transfered to xyz"); */
				return "Fund Transfer Processed";
			}
			else {
				return "Insufficient Balance";
			}
		}
	  
	/*
	 * @GetMapping("/api/transactions/{userid}") public List
	 * getTransactions(@PathVariable String userid) { return
	 * walletservice.getAllTransactions(userid); }
	 */
}

