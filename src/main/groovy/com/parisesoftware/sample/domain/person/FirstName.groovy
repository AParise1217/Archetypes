package com.parisesoftware.sample.domain.person

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.Validate.notBlank
import static org.apache.commons.lang3.StringUtils.trim

@Immutable
class FirstName {
    protected static final int MAX_LENGTH = 255

    String value

    /**
     * Factory Method to handle Construction of `FirstName` Immutable Objects
     *
     * @param value the Value to be
     * @return an Immutable First PersonName
     */
    static FirstName of(String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)
        if(!isTrue(trimmed.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }

        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new FirstName(value)
    }


}
