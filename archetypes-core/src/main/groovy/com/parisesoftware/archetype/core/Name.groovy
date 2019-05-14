package com.parisesoftware.archetype.core

import static org.apache.commons.lang3.Validate.notNull

/**
 *
 * @version 1.0.0
 * @since 1.0.0
 */
class Name {

    protected final String value

    protected Name(final String value) {
        this.value = value
    }

    String getValue() {
        return this.value
    }

    static Name of(final String value) {

        // verify the value was not null
        notNull(value)

        return new Name(value)
    }

}
