package com.library.libraryManagement.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.library.libraryManagement.enums.TransactionStatus;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String transactionId = UUID.randomUUID().toString();		// externalId
	
	@ManyToOne
	@JoinColumn
	private Student student;
	
	@ManyToOne
	@JoinColumn
	private Book book;
	
	private int fineAmount;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean isIssueOperation;
	
	@Enumerated(value = EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	@CreationTimestamp
	private Date transactionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student= student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	public boolean isIssueOperation() {
		return isIssueOperation;
	}

	public void setIssueOperation(boolean isIssueOperation) {
		this.isIssueOperation = isIssueOperation;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}

