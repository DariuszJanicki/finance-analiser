package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CurrencyAmount {

    private BigDecimal amount;
    private Currency currency;


    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
