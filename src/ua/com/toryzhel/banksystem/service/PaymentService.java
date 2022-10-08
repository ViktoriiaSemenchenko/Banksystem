package ua.com.toryzhel.banksystem.service;

import ua.com.toryzhel.banksystem.entity.Account;
import ua.com.toryzhel.banksystem.entity.Bill;

public class PaymentService {

    public void pay(Account account, int amount){

        Bill bill = account.getBill();

        if(bill.getAmount() < amount){
            System.out.println("Payment not possible, insufficient funds");
        } else {
            int currentBillAmount = bill.getAmount();
            System.out.println("Payment in progress, current balance: " + currentBillAmount);
            bill.setAmount(currentBillAmount - amount);
            System.out.println("Payment done, current balance: " + bill.getAmount());
        }

    }


}
