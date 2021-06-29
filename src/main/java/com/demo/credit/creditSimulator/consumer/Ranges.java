package com.demo.credit.creditSimulator.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ranges {
    private Integer start;
    private Integer end;

    public boolean checkInterval(int valueToCompare) {
        return (valueToCompare >= start && valueToCompare <= end);
    }
}
