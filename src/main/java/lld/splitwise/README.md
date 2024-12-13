**NOTE:**

- If validateInput in Expense class requires more logic as per splitType then may be create different Expense classes
  like ExactExpense having their own logic to be with OPEN-CLOSED solid principle.
- This is for one expense group only in case we need multiple group then we may have three level aggregation like Map<ExpenseGroup,Map<Giver,Map<Taker,Amount>>> and in front end we may be showing user borrow as per group and we may have another two level map as well like Map<Giver,Map<Taker,Amount>> which stores overall.
- For expense group addition, we may use observer pattern where we will inform user if he get added to any expense group or on any amount addition on his name in that expense group.

**OUTPUT:**

EXPENSE U2 3000 EQUAL 3 U1 U4 U3\
    Expense(id=1, expenseMetaData=ExpenseMetaData(description=Sonapur mela, imageUrl=s3Url), paidByUserId=U2, totalAmountPaid=3000.0, splits=[Split(userId=U1, amount=1000.0), Split(userId=U4, amount=1000.0), Split(userId=U3, amount=1000.0)], splitType=EQUAL)\
    Added expense and updated balance sheet\
SHOW\
    =======BALANCES=======\
    U1 owes U2 1000.0\
    U3 owes U2 1000.0\
    U4 owes U2 1000.0\
    ======================\
EXPENSE U1 1000 EQUAL 2 U2 U4\
    Expense(id=2, expenseMetaData=ExpenseMetaData(description=Sonapur mela, imageUrl=s3Url), paidByUserId=U1, totalAmountPaid=1000.0, splits=[Split(userId=U2, amount=500.0), Split(userId=U4, amount=500.0)], splitType=EQUAL)\
    Added expense and updated balance sheet\
SHOW\
    =======BALANCES=======\
    U1 owes U2 500.0\
    U3 owes U2 1000.0\
    U4 owes U1 500.0\
    U4 owes U2 1000.0\
    ======================\
EXPENSE U1 1000 EXACT 2 U2 900 U4 100\
    Expense(id=3, expenseMetaData=ExpenseMetaData(description=Sonapur mela, imageUrl=s3Url), paidByUserId=U1, totalAmountPaid=1000.0, splits=[Split(userId=U2, amount=900.0), Split(userId=U4, amount=100.0)], splitType=EXACT)\
    Added expense and updated balance sheet\
SHOW\
    =======BALANCES=======\
    U2 owes U1 400.0\
    U3 owes U2 1000.0\
    U4 owes U1 600.0\
    U4 owes U2 1000.0\
    ======================\
EXPENSE U1 1000 PERCENTAGE 2 U2 80 U4 20\
    Expense(id=4, expenseMetaData=ExpenseMetaData(description=Sonapur mela, imageUrl=s3Url), paidByUserId=U1, totalAmountPaid=1000.0, splits=[Split(userId=U2, amount=800.0), Split(userId=U4, amount=200.0)], splitType=PERCENTAGE)\
    Added expense and updated balance sheet\
SHOW\
    =======BALANCES=======\
    U2 owes U1 1200.0\
    U3 owes U2 1000.0\
    U4 owes U1 800.0\
    U4 owes U2 1000.0\
    ======================\
PAY\
    Unknown command -> PAY