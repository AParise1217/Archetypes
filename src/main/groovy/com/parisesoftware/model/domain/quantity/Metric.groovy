package com.parisesoftware.model.domain.quantity

import com.parisesoftware.model.domain.Name
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Metric {

    Name name

    Symbol symbol

    String definition

    static Metric of(final Name name, final Symbol symbol = Symbol.of(null), final String definition = null) {

        // verify the name was not null
        notNull(name)

        return new Metric(name: name, symbol: symbol, definition: definition)
    }

}
