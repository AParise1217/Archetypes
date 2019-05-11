package com.parisesoftware.archetype.money

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

/**
 * ISO 4217 Standard Assigned Numeric Code
 */
class NumericCode {

    final String value

    protected NumericCode(final String value) {
        this.value = value
    }

    static NumericCode of(final String value) {

        // verify the value was not null
        notNull(value)

        // verify the value was numeric
        StringUtils.isNumeric(value)

        return new NumericCode(value)
    }

}
