package com.parisesoftware.archetype.quantity

class Symbol {

    final Character value

    protected Symbol(final Character value) {
        this.value = value
    }

    static Symbol of(final Character value) {
        // verify the value was not null
        return new Symbol(value: value)
    }

    static Symbol generateNullObject() {
        return of(null)
    }

}
