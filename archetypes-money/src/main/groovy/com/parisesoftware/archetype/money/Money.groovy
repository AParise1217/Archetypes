package com.parisesoftware.archetype.money

import com.parisesoftware.archetype.core.exception.TypeMismatchException
import com.parisesoftware.archetype.money.exception.CurrencyMismatchException
import com.parisesoftware.archetype.quantity.Metric
import com.parisesoftware.archetype.quantity.Quantity

import static org.apache.commons.lang3.Validate.notNull

class Money extends Quantity {

    final Currency currency

    protected Money(final Currency currency, final double amount, final Metric metric) {
        super(amount, metric)
        this.currency = currency
    }

    static Money of(final Currency currency, final double amount, final Metric metric) {

        // verify the currency was not null
        notNull(currency)

        return new Money(currency, amount, metric)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Quantity add(Quantity otherQuantity) {
        throwExceptionIfNotTypeMoney(otherQuantity)
        throwExceptionIfNotSameCurrency(this, otherQuantity as Money)

        return super.add(otherQuantity)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Quantity subtract(Quantity otherQuantity) {
        throwExceptionIfNotTypeMoney(otherQuantity)
        throwExceptionIfNotSameCurrency(this, otherQuantity as Money)

        return super.subtract(otherQuantity)
    }

    /**
     * Verify the given instance is of Type Money
     * @param anInstance to check
     */
    private static void throwExceptionIfNotTypeMoney(Object anInstance) {
        // verify the otherQuantity is of type Money
        if (!(anInstance instanceof Money)) {
            throw new TypeMismatchException('Operations on monetary quantities must be performed against another monetary quantity.')
        }
    }

    /**
     * Verify the Money values have the same underlying currencies
     * @param firstMoney
     * @param secondMoney
     */
    private static void throwExceptionIfNotSameCurrency(Money firstMoney, Money secondMoney) {
        if(!isSameCurrency(firstMoney, secondMoney)) {
            throw new CurrencyMismatchException('Operations on monetary quantities must have the same currency.')
        }
    }

    /**
     * Helper to check if the same currency is present in both monetary values
     * @param firstMoney
     * @param secondMoney
     * @return {@code boolean}
     */
    private static boolean isSameCurrency(Money firstMoney, Money secondMoney) {
        return (firstMoney.currency == secondMoney.currency)
    }

}
