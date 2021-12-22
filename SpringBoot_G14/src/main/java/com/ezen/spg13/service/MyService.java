package com.ezen.spg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg13.dao.ITransactionDao1;
import com.ezen.spg13.dao.ITransactionDao2;

@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;
	
	@Autowired
	ITransactionDao2 td2;

	@Autowired
	TransactionTemplate tt;
	
	public int buy(String id, int amount, String error) {
		int n=0;
		
		try {
			
			tt.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					td1.buy(id, amount);  //에러x
					int n=0;
					if(error.equals("1"))  n=10/0; 
				td2.buy(id, amount);     
				System.out.println("Transaction Commit"); 
				}
			});				
				return 1;  //에러o-실행x
		}catch(Exception e) {	
			System.out.println("Transaction RollBack");
			return 0; 
		}	
	}
}
