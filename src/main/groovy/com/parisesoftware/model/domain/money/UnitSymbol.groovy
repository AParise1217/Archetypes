package com.parisesoftware.model.domain.money

import groovy.transform.Immutable

@Immutable
class UnitSymbol {

    Character value

    static UnitSymbol of(final Character value) {
        return new UnitSymbol(value: value)
    }

}
