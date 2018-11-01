package com.parisesoftware.sample.domain.quantity

import groovy.transform.Immutable

@Immutable
class Symbol {

    Character value

    static Symbol of(final Character value) {
        // verify the value was not null
        return new Symbol(value: value)
    }

}
