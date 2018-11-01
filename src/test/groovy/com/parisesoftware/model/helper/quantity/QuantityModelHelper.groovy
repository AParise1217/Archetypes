package com.parisesoftware.model.helper.quantity

import com.parisesoftware.model.domain.Name
import com.parisesoftware.model.domain.quantity.Metric
import com.parisesoftware.model.domain.quantity.Quantity


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
