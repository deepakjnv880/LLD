package lld.splitwise;

import lld.splitwise.model.expense.Expense;
import lld.splitwise.model.expense.ExpenseMetaData;
import lld.splitwise.model.expense.InvalidExpenseException;
import lld.splitwise.model.split.*;
import lld.splitwise.service.SplitWiseService;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws InvalidExpenseException {
        String[] commands = {"EXPENSE U2 3000 EQUAL 3 U1 U4 U3", "SHOW", "EXPENSE U1 1000 EQUAL 2 U2 U4", "SHOW", "EXPENSE U1 1000 EXACT 2 U2 900 U4 100", "SHOW", "EXPENSE U1 1000 PERCENTAGE 2 U2 80 U4 20", "SHOW", "PAY"};
        SplitWiseService splitWiseService = new SplitWiseService();
        int expenseId = 1;
        for (String command : commands) {
            System.out.println("COMMAND -> " + command);
            String[] words = command.split(" ");
            String commandType = words[0];

            switch (commandType) {
                case "EXPENSE":
                    String paidByUser = words[1];
                    double totalAmountPaid = Double.parseDouble(words[2]);
                    SplitType splitType = SplitType.valueOf(words[3]);
                    int noOfPeopleToSplit = Integer.parseInt(words[4]);
                    List<Split> splits = new ArrayList<>();

                    switch (splitType) {
                        case EQUAL:
                            for (int i = 5; i < words.length; i++) {
                                splits.add(new EqualSplit(words[i], noOfPeopleToSplit, totalAmountPaid));
                            }
                            break;
                        case EXACT:
                            for (int i = 5; i < words.length; i += 2) {
                                splits.add(new ExactSplit(words[i], Double.parseDouble(words[i + 1])));
                            }
                            break;
                        case PERCENTAGE:
                            for (int i = 5; i < words.length; i += 2) {
                                splits.add(new PercentageSplit(words[i], totalAmountPaid, Double.parseDouble(words[i + 1])));
                            }
                            break;
                        default:
                            return;
                    }
                    Expense expense = new Expense(expenseId++, new ExpenseMetaData("Sonapur mela", "s3Url"), paidByUser, totalAmountPaid, splits, splitType);
                    System.out.println(expense);
                    splitWiseService.addExpense(expense);
                    break;
                case "SHOW":
                    splitWiseService.showBalances();
                    break;
                default:
                    System.out.println("Unknown command -> " + command);
                    break;
            }
        }
    }
}
