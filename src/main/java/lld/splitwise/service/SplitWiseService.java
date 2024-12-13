package lld.splitwise.service;

import lld.splitwise.model.expense.Expense;
import lld.splitwise.repository.SplitWiseRepository;

import java.util.Map;

public class SplitWiseService {

    private final SplitWiseRepository splitWiseRepository;

    public SplitWiseService() {
        splitWiseRepository = new SplitWiseRepository();
    }

    public void addExpense(Expense expense) {
        splitWiseRepository.addExpense(expense);
    }

    public void showBalances() {
        System.out.println("\t=======BALANCES=======");
        Map<String, Map<String, Double>> balanceSheet = splitWiseRepository.getBalanceSheet();
        for (String user1 : balanceSheet.keySet()) {
            for (String user2 : balanceSheet.get(user1).keySet()) {
                double amount = balanceSheet.get(user1).get(user2);
                if (amount < 0) {
                    System.out.println("\t"+user1 + " owes " + user2 + " " + Math.abs(amount));
                }
            }
        }
        System.out.println("\t======================");
    }
}
