package lld.splitwise.repository;

import lld.splitwise.model.expense.Expense;
import lld.splitwise.model.split.Split;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class SplitWiseRepository {
    List<Expense> expenses;
    Map<String, Map<String, Double>> balanceSheet;

    public SplitWiseRepository() {
        expenses = new ArrayList<>();
        balanceSheet = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);

        if (!balanceSheet.containsKey(expense.getPaidByUserId())) {
            balanceSheet.put(expense.getPaidByUserId(), new HashMap<>());
        }

        for (Split split : expense.getSplits()) {
            balanceSheet.get(expense.getPaidByUserId())
                    .put(
                            split.getUserId(),
                            balanceSheet
                                    .get(expense.getPaidByUserId())
                                    .getOrDefault(split.getUserId(), 0.0) + split.getAmount());

            if (!balanceSheet.containsKey(split.getUserId())) {
                balanceSheet.put(split.getUserId(), new HashMap<>());
            }

            balanceSheet.get(split.getUserId())
                    .put(
                            expense.getPaidByUserId(),
                            balanceSheet
                                    .get(split.getUserId())
                                    .getOrDefault(expense.getPaidByUserId(), 0.0) - split.getAmount());
        }
        System.out.println("Added expense and updated balance sheet");
    }
}
