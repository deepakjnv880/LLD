package lld.splitwise.model.expense;

import lld.splitwise.model.split.Split;
import lld.splitwise.model.split.SplitType;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
public class Expense {
    private final int id;
    private final ExpenseMetaData expenseMetaData;
    private final String paidByUserId;
    private final double totalAmountPaid;
    private final List<Split> splits;
    private final SplitType splitType;

    public Expense(int id, ExpenseMetaData expenseMetaData, String paidByUserId, double totalAmountPaid, List<Split> splits, SplitType splitType) throws InvalidExpenseException {
        if (!isValidateExpense(splits, totalAmountPaid)) {
            throw new InvalidExpenseException("Expense is not valid " + this);
        }
        this.id = id;
        this.expenseMetaData = expenseMetaData;
        this.paidByUserId = paidByUserId;
        this.totalAmountPaid = totalAmountPaid;
        this.splits = splits;
        this.splitType = splitType;
    }

    private boolean isValidateExpense(List<Split> splits, double totalAmountPaid) {
        return totalAmountPaid == splits.stream().map(Split::getAmount).reduce(Double::sum).orElse(-1D);
    }
}
