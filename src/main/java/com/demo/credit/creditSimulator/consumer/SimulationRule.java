package com.demo.credit.creditSimulator.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SimulationRule {

    private final Integer startAmount;
    private final Integer endAmount;

    private final Integer startQuotas;
    private final Integer endQuotas;

    private final Integer startIncome;
    private final Integer endIncome;

    public SimulationRule(Integer startAmount, Integer endAmount, Integer startQuotas, Integer endQuotas, Integer startIncome, Integer endIncome) {
        this.startAmount = startAmount;
        this.endAmount = endAmount;
        this.startQuotas = startQuotas;
        this.endQuotas = endQuotas;
        this.startIncome = startIncome;
        this.endIncome = endIncome;
    }

    public boolean check(Integer amount, Integer quotas, Integer income) {
        return checkInterval(amount, startAmount, endAmount)
                && checkInterval(quotas, startQuotas, endQuotas)
                && checkInterval(income, startIncome, endIncome);
    }

    public boolean checkInterval(int valueToCompare, int start, int end) {
        return (valueToCompare >= start && valueToCompare <= end);
    }
}
