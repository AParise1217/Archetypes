package com.parisesoftware.archetype.helper.quantity

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.quantity.Metric
import com.parisesoftware.archetype.quantity.Quantity

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
