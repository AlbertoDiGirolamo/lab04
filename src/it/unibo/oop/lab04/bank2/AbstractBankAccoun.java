package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;
import it.unibo.oop.lab04.bank.SimpleBankAccount;

public abstract class AbstractBankAccoun implements BankAccount {
	/*
	void computeManagementFees(int usrID);

    void deposit(int usrID, double amount);

    void depositFromATM(int usrID, double amount);

    double getBalance();

    int getNTransactions();

    void withdraw(int usrID, double amount);

    void withdrawFromATM(int usrID, double amount);
    */
	
	private static final double MANAGEMENT_FEE = 5;
	
	private int usrID;
	private double balance;
	private int nTransactions;
	
	
	protected boolean checkUser(final int id) {
        return this.usrID == id;
    }
	
	public void computeManagementFees	(int usrID) {
		if (checkUser(usrID)) {
            balance -= SimpleBankAccount.MANAGEMENT_FEE;
        }
	}
	
	
	 public void deposit(int usrID, double amount) {
		 this.transactionOp(usrID, amount);
		    
	 }
	 
	 private void transactionOp(final int usrID, final double amount) {
		 if (checkUser(usrID)) {
			 this.balance += amount;
			 this.incTransactions();
		 }
	 }
	 
	 protected void incTransactions() {
		 this.nTransactions++;
     }
	 public void depositFromATM(final int usrID, final double amount) {
		 this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
     }
}
