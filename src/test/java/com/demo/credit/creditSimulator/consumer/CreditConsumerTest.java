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

    //Check approve evaluation according range rules
    @Test
    public void test1(){
        //check first range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 150000; // $150.000
        Integer quotas = 5;
        Integer income = 1000000; // $1.000.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }

    @Test
    public void test2(){
        //check second range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 1500000; // $1.500.000
        Integer quotas = 15;
        Integer income = 1000000; // $1.000.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }

    @Test
    public void test3(){
        //check third range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 350000; // $3.500.000
        Integer quotas = 18;
        Integer income = 1000000; // $800.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isTrue();
    }

    //Check reject evaluation according range rules
    @Test
    public void test4(){
        //check first range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 300000; // $300.000
        Integer quotas = 2;
        Integer income = 1000000; // $1.000.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isFalse();
    }

    @Test
    public void test5(){
        //check second range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 1500000; // $1.500.000
        Integer quotas = 15;
        Integer income = 300000; // $300.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isFalse();
    }

    @Test
    public void test6(){
        //check third range test case
        String name = "peter";
        String email = "peter@email.com";
        Integer amount = 3500000; // $3.500.000
        Integer quotas = 9;
        Integer income = 800000; // $800.000
        CreditConsumer consumer = new CreditConsumer(name, email, amount, quotas, income);

        //check evaluation that's correct
        assertThat(consumer.evaluate()).isFalse();
    }
}
