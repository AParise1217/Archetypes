package com.parisesoftware.archetype.money

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

/**
 * ISO 4217 Standard Assigned Alphabetic Code
 */
class AlphabeticCode {

    final String value

    protected AlphabeticCode(final String value) {
        this.value = value
    }

    static AlphabeticCode of(final String value) {

        // verify the value was not null
        notNull(value)

        // verify the value was not numeric
        !StringUtils.isNumeric(value)

        return new AlphabeticCode(value: value)
    }

}
