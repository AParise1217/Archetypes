package com.parisesoftware.archetype.person

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

class LastName {

    protected static final int MAX_LENGTH = 255

    final String value

    protected LastName(final String value) {
        this.value = value
    }

    /**
     * Factory Method to handle Construction of `LastName` Immutable Objects
     *
     * @param value the Value to be
     * @return an Immutable Last PersonName
     */
    static LastName of(final String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)
        throwExceptionIfOverMaximumLength(trimmed)

        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new LastName(value)
    }

    private static void throwExceptionIfOverMaximumLength(String value) {
        if(!isTrue(value.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }
    }

}
