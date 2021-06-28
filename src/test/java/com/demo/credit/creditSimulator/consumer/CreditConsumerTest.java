package com.demo.credit.creditSimulator.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CreditConsumerTest {

    @Test
    public void givenCreditConsumerWhenEmptyValuesThenIllegalArgumentException() {

        String name = null;
        String email = "";
        Integer amount = 0;
        Integer quotas = 0;
        Integer income = 0;

        //check when some field is empty or null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditConsumer(name, email, amount, quotas, income);
        });

    }

    @Test
    public void givenAmount300000WhenQuotaIs6AndIncomeIs500000ThenOk(){
        //Test first range rules
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 300000;
        Integer quotas = 6;
        Integer income = 600000;

        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);


        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }

    @Test
    public void givenAmount1500000WhenQuotaIs18AndIncomeIs800000ThenOk(){
        //Test second range rules
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 1500000;
        Integer quotas = 18;
        Integer income = 800000;

        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }

    @Test
    public void givenAmount3500000WhenQuotaIs20AndIncomeIs900000ThenOk(){
        //Test second range rules
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 3500000;
        Integer quotas = 20;
        Integer income = 900000;

        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }
}
