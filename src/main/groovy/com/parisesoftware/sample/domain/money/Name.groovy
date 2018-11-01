package com.parisesoftware.sample.domain.money

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Name {

    String value

    static Name of(final String value) {

        // verify the value was not null
        notNull(value)

        return new Name(value: value)
    }

}
