package com.demo.credit.creditSimulator.consumer;

import lombok.Getter;

@Getter
public class CreditResponse {

    private Boolean isValid;
    private String name;
    private String email;
    private Integer amount;
    private Integer quotas;
    private Integer income;

    public void loadValues(CreditConsumer consumer, boolean answer){
        this.name = consumer.getName();
        this.email = consumer.getEmail();
        this.amount = consumer.getAmount();
        this.quotas = consumer.getQuotas();
        this.income = consumer.getIncome();
        this.isValid = answer;
    }

}
