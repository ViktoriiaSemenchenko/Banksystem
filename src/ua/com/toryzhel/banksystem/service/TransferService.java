package ua.com.toryzhel.banksystem.service;

import ua.com.toryzhel.banksystem.entity.Account;

import java.sql.SQLOutput;

public class TransferService {

    public void transfer (Account accountFrom, Account accountTo, int amount){

        int billFromAmount = accountFrom.getBill().getAmount();
        int billToAmount = accountTo.getBill().getAmount();

        if (billFromAmount < amount){
            System.out.println("Transfer not possible, insufficient funds");
        } else {
            System.out.println("Current balance " + accountFrom.getAccountHolder().getName() + " : "
                    + accountFrom.getBill().getAmount());
            System.out.println("Current balance " + accountTo.getAccountHolder().getName() + " : "
                    + accountTo.getBill().getAmount());
            System.out.println("Transfer from - " + accountFrom.getAccountHolder().getName() + " to - "
                    + accountTo.getAccountHolder().getName());
            accountFrom.getBill().setAmount(billFromAmount - amount);
            accountTo.getBill().setAmount(billToAmount + amount);
            System.out.println("Current balance " + accountFrom.getAccountHolder().getName() + " : "
                    + accountFrom.getBill().getAmount());
            System.out.println("Current balance " + accountTo.getAccountHolder().getName() + " : "
                    + accountTo.getBill().getAmount());


        }


    }

}
