package com.parisesoftware.archetype.person

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.Validate.notBlank
import static org.apache.commons.lang3.StringUtils.trim

class FirstName {

    protected static final int MAX_LENGTH = 255

    final String value

    protected FirstName(final String value) {
        this.value = value
    }

    /**
     * Factory Method to handle Construction of `FirstName` Immutable Objects
     *
     * @param value the Value to be
     * @return an Immutable First PersonName
     */
    static FirstName of(final String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)

        throwExceptionIfOverMaximumLength(trimmed)

        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new FirstName(value)
    }

    private static void throwExceptionIfOverMaximumLength(String value) {
        if(!isTrue(value.length() <= MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }
    }

}
