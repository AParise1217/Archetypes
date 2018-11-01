package com.parisesoftware.model.domain.quantity

import com.parisesoftware.model.domain.quantity.exception.MetricTypeMismatchException
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Quantity {

    double amount

    Metric metric

    static Quantity of(final double amount, final Metric metric) {

        // verify the amount was a real number
        assert((amount * amount) >= 0)

        // verify the metric was not null
        notNull(metric)

        return new Quantity(amount: amount, metric: metric)
    }

    Quantity add(Quantity quantity) {
        throwExceptionIfMetricMismatch(quantity)

        final double addedValue = quantity.amount + this.amount

        return of(addedValue, this.metric)
    }

    Quantity subtract(Quantity quantity) {
        throwExceptionIfMetricMismatch(quantity)

        final double subtractedValue = this.amount - quantity.amount

        return of(subtractedValue, this.metric)
    }

    private void throwExceptionIfMetricMismatch(Quantity quantity) {
        if(this.metric != quantity.metric) throw new MetricTypeMismatchException()
    }

}
