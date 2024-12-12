NOTE:

- If validateInput in Expense class requires more logic as per splitType then may be create different Expense classes
  like ExactExpense having their own logic to be with OPEN-CLOSED solid principle.
- This is for one expense group only in case we need multiple group then we may have three level aggregation like Map<ExpenseGroup,Map<Giver,Map<Taker,Amount>>> and in front end we may be showing user borrow as per group and we may have another two level map as well like Map<Giver,Map<Taker,Amount>> which stores overall.
- For expense group addition, we may use observer pattern where we will inform user if he get added to any expense group or on any amount addition on his name in that expense group.