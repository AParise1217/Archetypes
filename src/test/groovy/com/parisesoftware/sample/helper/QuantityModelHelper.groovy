package com.parisesoftware.sample.helper

import com.parisesoftware.sample.domain.money.*
import com.parisesoftware.sample.domain.quantity.Metric
import com.parisesoftware.sample.domain.quantity.Quantity

final class QuantityModelHelper {

    private QuantityModelHelper() {}

    static Quantity quantity() {
        return Quantity.of(amount(), metric())
    }
    
    static double amount() {
        return 500.00
    }

    static Metric metric() {
        return Metric.of(name())
    }

    static Name name() {
        return Name.of('Miles')
    }

}
