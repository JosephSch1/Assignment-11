package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository repo;
	
	public List<Transaction> listAll() {
		List<Transaction> transactions = repo.findAll();
		Collections.sort(transactions, (transaction1, transaction2) -> transaction1.getDate().compareTo(transaction2.getDate()));
		return transactions;
	}
	
	public Transaction findById(Long id) {
		Transaction found = null;
		for (int i = 0; i < repo.findAll().size(); i++) {
			if (repo.findAll().get(i).getId().equals(id)) {
				found = repo.findAll().get(i);
			}
		}
		return found;					
	}
}
