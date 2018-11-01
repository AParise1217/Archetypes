package com.parisesoftware.sample.domain.money

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class UnitSymbol {

    Character value

    static UnitSymbol of(final Character value) {
        return new UnitSymbol(value: value)
    }

}
