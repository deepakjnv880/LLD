package lld.splitwise.model.split;

public class EqualSplit extends Split {
    public EqualSplit(String userId, int noOfPeopleToSplit, double totalAmountPaid) {
        super(userId, totalAmountPaid / noOfPeopleToSplit);
    }
}
