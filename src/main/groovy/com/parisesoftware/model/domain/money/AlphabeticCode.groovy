package com.parisesoftware.model.domain.money

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

/**
 * ISO 4217 Standard Assigned Alphabetic Code
 */
@Immutable
class AlphabeticCode {

    String value

    static AlphabeticCode of(final String value) {

        // verify the value was not null
        notNull(value)

        // verify the value was not numeric
        !StringUtils.isNumeric(value)

        return new AlphabeticCode(value: value)
    }

}
