package com.parisesoftware.sample.domain

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class LastName {
    protected static final int MAX_LENGTH = 255

    String value

    /**
     * Factory Method to handle Construction of `LastName` Immutable Objects
     *
     * @param value the Value to be
     * @return an Immutable Last Name
     */
    static LastName of(String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)
        if(!isTrue(trimmed.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }

        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new LastName(value)
    }


}
