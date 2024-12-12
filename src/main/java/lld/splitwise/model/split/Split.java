package lld.splitwise.model.split;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class Split {
    private String userId;
    private double amount;
}
