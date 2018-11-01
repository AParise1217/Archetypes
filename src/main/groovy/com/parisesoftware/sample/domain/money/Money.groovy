package com.parisesoftware.sample.domain.money

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Money {

    Currency currency

    static Money of(final Currency currency) {

        // verify the currency was not null
        notNull(currency)

        return new Money(currency: currency)
    }

}
