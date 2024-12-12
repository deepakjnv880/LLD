package lld.splitwise.model.split;

public class PercentageSplit extends Split {
    public PercentageSplit(String userId, double totalAmountPaid, double percentage) {
        super(userId, (totalAmountPaid * percentage) / 100);
    }
}
