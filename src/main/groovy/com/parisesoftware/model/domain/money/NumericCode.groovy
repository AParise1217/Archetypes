package com.parisesoftware.model.domain.money

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

/**
 * ISO 4217 Standard Assigned Numeric Code
 */
@Immutable
class NumericCode {

    String value

    static NumericCode of(final String value) {

        // verify the value was not null
        notNull(value)

        // verify the value was numeric
        StringUtils.isNumeric(value)

        return new NumericCode(value: value)
    }

}
