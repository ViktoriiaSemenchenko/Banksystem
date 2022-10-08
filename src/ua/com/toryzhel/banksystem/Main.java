package ua.com.toryzhel.banksystem;

import ua.com.toryzhel.banksystem.entity.Account;
import ua.com.toryzhel.banksystem.entity.Bill;
import ua.com.toryzhel.banksystem.entity.Person;
import ua.com.toryzhel.banksystem.service.DepositService;
import ua.com.toryzhel.banksystem.service.PaymentService;
import ua.com.toryzhel.banksystem.service.TransferService;

/**
 *
 * В данном домашнем задании нужно написать небольшую банковскую систему.
 * Минимальная банковская система будет состоять из классов (сущностей): Bill (счет) Account (аккаунт)
 * Person (личность человека) Deposit (пополнение счета) Payment (платеж).
 *
 * Связи между сущностями будут такие: Account имеет поле типа Person, так же Account имеет поле типа Bill
 * Deposit и Payment имеют по одному полю Bill
 *
 * Класс Person будет иметь следующие поля: имя, фамилия, номер телефона.
 * Класс Account будет иметь поля: Bill и Person.
 * Класс Bill будет содеражать поле с числовым значением внутри: например Integer amount
 * Класс Payment будет содержать поле Bill
 * Класс Deposit будет содержать поле Bill
 *
 * Сценарии:
 * Созадние нескольких аккаунтов и счетов
 * В классах-сервисах (Напримет класс PaymentService) совершенить платежа (уменьшение счета)
 * И депозит (DepositService) (увеличение счета)
 *
 * Перевод денег с одного аккаунта на другой
 * Создать дополнительный класс TransferService, создать в нем метод transfer и реализовать логику перевода денег с одного аккаунта на другой
 *
 * В методе main не должно происходить никакой логики, кроме вызовов сервисов.
 * Сервисы будут выполнять все действия, в методе main можно только создавать изначальные объекты и вызывать сервисы
 *
 * Так же стоит предусмотреть критические случаи, например не оставлять отрицательную сумму на счету
 *
 */


public class Main {

    public static void main(String[] args) {

        Person LoriPerson = new Person ("Lori", "Cat", "+380637462745");
        Bill LoriBill = new Bill(10000);
        Account LoriAccount = new Account(LoriPerson, LoriBill);

        Person MartinPerson = new Person("Martin", "Dog", "+380746583754");
        Bill MartinBill = new Bill(13700);
        Account MartinAccount = new Account(MartinPerson, MartinBill);

        PaymentService paymentService = new PaymentService();
        paymentService.pay(LoriAccount, 12000);
        paymentService.pay(MartinAccount, 14700);

        DepositService depositService = new DepositService();
        depositService.deposit(LoriAccount, 3000);
        depositService.deposit(MartinAccount, 4200);

        TransferService transferService = new TransferService();
        transferService.transfer(MartinAccount, LoriAccount, 50000);
    }


}
