package ua.com.toryzhel.banksystem.service;

import ua.com.toryzhel.banksystem.entity.Account;
import ua.com.toryzhel.banksystem.entity.Bill;

public class DepositService {

    public void deposit (Account account, int amount){
        Bill bill = account.getBill();
        int currentBillAmount = bill.getAmount();
        System.out.println("Deposit in progress, current balance: " + currentBillAmount);
        bill.setAmount(currentBillAmount + amount);
        System.out.println("Deposit done, current balance: " + bill.getAmount());


    }


}
