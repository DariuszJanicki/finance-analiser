package factory;

import com.google.common.collect.Lists;
import lombok.Getter;
import model.AccountOwner;
import model.AccountsList;
import model.Currency;
import model.CurrencyAmount;
import model.Entry;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum EntryFactory {

    factory;

    /* ========== PUBLIC ========== */
    public Entry createEntry(String[] entryArray) {
        AccountOwner receiver = accountsList.getReceiver(entryArray[2]);

        Entry entry = new Entry(
                parseDate(entryArray[0]),
                parseDate(entryArray[1]),
                receiver,
                entryArray[3],
                entryArray[4],
                entryArray[5],
                new CurrencyAmount(parseBigDecimal(entryArray[6]), parseCurrency(entryArray[7])),
                new CurrencyAmount(parseBigDecimal(entryArray[8]), parseCurrency(entryArray[9])),
                new CurrencyAmount(parseBigDecimal(entryArray[10]), parseCurrency(entryArray[11])),
                entryArray[12],
                new CurrencyAmount(parseBigDecimal(entryArray[13]), parseCurrency(entryArray[14])));

        receiver.add(entry);
        return entry;
    }

    /* ========== PRIVATE ========== */
    @Getter
    private AccountsList accountsList = new AccountsList();

    private Currency parseCurrency(String string) {
        return StringUtils.isNotBlank(string) && Lists.newArrayList(Currency.values()).contains(string)
                ? Currency.valueOf(string)
                : null;
    }

    private LocalDate parseDate(String string) {
        return StringUtils.isNotBlank(string)
                ? LocalDate.parse(string, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                : null;
    }

    private Long parseLong(String string) {
        return StringUtils.isNotBlank(string)
                ? Long.valueOf(string)
                : null;
    }

    private BigDecimal parseBigDecimal(String string) {
        return StringUtils.isNotBlank(string)
                ? BigDecimal.valueOf(Double.parseDouble(string.replace(",",".")))
                : null;
    }

}
