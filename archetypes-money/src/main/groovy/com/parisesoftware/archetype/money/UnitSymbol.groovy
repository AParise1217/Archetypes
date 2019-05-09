package com.parisesoftware.archetype.money

import groovy.transform.Immutable

@Immutable
class UnitSymbol {

    Character value

    static UnitSymbol of(final Character value) {
        return new UnitSymbol(value: value)
    }

}
