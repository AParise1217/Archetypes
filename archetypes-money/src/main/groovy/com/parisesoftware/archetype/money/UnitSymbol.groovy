package com.parisesoftware.archetype.money

class UnitSymbol {

    final Character value

    protected UnitSymbol(final Character value) {
        this.value = value
    }

    static UnitSymbol of(final Character value) {
        return new UnitSymbol(value)
    }

}
