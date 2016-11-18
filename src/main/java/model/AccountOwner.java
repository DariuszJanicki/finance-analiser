package model;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class AccountOwner {

    private String name;
    private List<Entry> entries = Lists.newArrayList();

    public AccountOwner(String name) {
        this.name = name;
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    @Override
    public String toString() {
       return name + " " + entries.size() + " " + sum();
    }

    public BigDecimal sum() {
        return entries.stream()
                .filter(e -> e.getTransactionAmount().getAmount() != null)
                .map(e -> e.getTransactionAmount().getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
