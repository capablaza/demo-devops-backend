package com.demo.credit.creditSimulator.consumer;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class CreditConsumer {

    private String name;
    private String email;
    private Integer amount;
    private Integer quotas;
    private Integer income;

    private Map<String, Ranges> amountRanges;
    private Map<String, Ranges> quotasRanges;
    private Map<String, Ranges> incomeRanges;

    public CreditConsumer(@NonNull String name,@NonNull  String email,@NonNull  Integer amount,@NonNull  Integer quotas,@NonNull  Integer income) {
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.quotas = quotas;
        this.income = income;
    }

    private void prepareRanges() {

        //prepare amount ranges
        amountRanges = new HashMap<>();
        amountRanges.put("R1", new Ranges(100000, 1000000));
        amountRanges.put("R2", new Ranges(1000001, 3000000));
        amountRanges.put("R3", new Ranges(3000001, 5000000));

        //prepare quotas ranges
        quotasRanges = new HashMap<>();
        quotasRanges.put("R1", new Ranges(3, 12));
        quotasRanges.put("R2", new Ranges(13, 24));
        quotasRanges.put("R3", new Ranges(25, 36));

        //prepare incomes ranges
        incomeRanges = new HashMap<>();
        incomeRanges.put("R1", new Ranges(300000, 500000));
        incomeRanges.put("R2", new Ranges(500001, 1000000));
    }

    public boolean evaluate() {
        this.prepareRanges();
        //check amount = R1 , quotas = R1-3, income = R1
        return checkRange(amount, this.amountRanges, "R1", "R2", "R3")
                && checkRange(quotas, this.quotasRanges, "R1", "R2", "R3")
                && checkRange(income, this.incomeRanges, "R1", "R2");
    }

    private boolean checkRange(Integer value, Map<String, Ranges> mapRanges, String... rangeName) {
        for (String name : rangeName) {
            Ranges ranges = mapRanges.get(name);
            boolean isValid = checkInterval(value, ranges.getStart(), ranges.getEnd());
            if (isValid) return true;
        }
        return false;
    }

    private boolean checkInterval(int value, int startLimit, int endLimit) {
        return (value >= startLimit && value <= endLimit);
    }

}
