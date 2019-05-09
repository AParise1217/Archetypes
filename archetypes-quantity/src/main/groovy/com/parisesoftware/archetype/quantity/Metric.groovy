package com.parisesoftware.archetype.quantity

import com.parisesoftware.archetype.core.Name
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

class Metric {

    final Name name

    final Symbol symbol

    final String definition

    protected Metric(final Name name, final Symbol symbol, final String definition) {
        this.name = name
        this.symbol = symbol
        this.definition = definition
    }

    static Metric of(final Name name, final Symbol symbol, final String definition) {

        // verify the name was not null
        notNull(name)

        return new Metric(name, symbol, definition)
    }

    static Metric of(final Name name, final Symbol symbol) {

        // verify the name was not null
        notNull(name)

        return new Metric(name, symbol, StringUtils.EMPTY)
    }

    static Metric of(final Name name, final String definition) {

        // verify the name was not null
        notNull(name)

        return new Metric(name, Symbol.generateNullObject(), definition)
    }

    static Metric of(final Name name) {

        // verify the name was not null
        notNull(name)

        return new Metric(name, Symbol.generateNullObject(), StringUtils.EMPTY)
    }

}
