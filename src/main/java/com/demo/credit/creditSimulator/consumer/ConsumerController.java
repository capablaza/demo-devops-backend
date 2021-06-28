package com.demo.credit.creditSimulator.consumer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("simulator")
public class ConsumerController {

    @PostMapping
    public CreditResponse simulate(@RequestBody CreditConsumer consumer) {
        CreditResponse response = new CreditResponse();
        response.loadValues(consumer, consumer.evaluate());
        return response;
    }

}
