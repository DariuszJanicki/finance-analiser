package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Entry {

    private LocalDate transactionDate;
    private LocalDate accountingDate;
    private AccountOwner receiver;
    private String title;
    private String details;
    private String transactionNumber;

    private CurrencyAmount transactionAmount;
    private CurrencyAmount blockedAmount;
    private CurrencyAmount currencyAmount;

    private String account;
    private CurrencyAmount balance;

    @Override
    public String toString() {
        return balance.toString();
    }
}
