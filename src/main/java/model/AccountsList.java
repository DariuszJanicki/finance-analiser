package model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.val;

import java.util.List;

public class AccountsList {

    @Getter
    private List<AccountOwner> accounts = Lists.newArrayList();

    public AccountOwner getReceiver(String receiver) {
        val first = accounts.stream().filter(a -> a.getName().equals(receiver)).findFirst();

        if (first.isPresent()) {
            return first.get();
        } else {
            val accountOwner = new AccountOwner(receiver);
            accounts.add(accountOwner);
            return accountOwner;
        }
    }

    public List<AccountOwner> getSorted() {
        val accountsCopy = Lists.newArrayList(accounts);
        accountsCopy.sort((o1, o2) -> o1.sum().compareTo(o2.sum()));
        return accountsCopy;
    }
}
