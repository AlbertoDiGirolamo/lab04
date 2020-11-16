package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

	
	
	
	private static final double TRANSACTION_FEE = 0.1;
	
	
	//private double balance = super.getBalance();
    //private int nTransactions = super.getNTransactions();

	
	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
		// TODO Auto-generated constructor stub
	}
	
	
	public void computeManagementFees(final int usrID) {
    final double feeAmount = MANAGEMENT_FEE + (getNTransactions()* ExtendedStrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
           // balance -= feeAmount;
            setBalance(getBalance()-feeAmount);
            resetTransactions();
        }
    }
	 private boolean isWithdrawAllowed(final double amount) {
	        return getBalance() > amount;
	 }
	

}
