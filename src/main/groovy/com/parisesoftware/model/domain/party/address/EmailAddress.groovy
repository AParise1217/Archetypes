package com.parisesoftware.model.domain.party.address

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class EmailAddress extends Address {

    private static final String REGEX_MALFORMED_EMAIL = '^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.][a-zA-Z0-9.-]+$'

    protected static final int MIN_LENGTH = 5
    protected static final int MAX_LENGTH = 256

    String value

    /**
     * Factory Method to handle Construction of `EmailAddress` Immutable Objects
     *
     * @param value the Value to be encapsulated
     * @return an Immutable EmailAddress
     */
    static EmailAddress of(String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)

        // Check Minimum Length
        throwExceptionIfUnderMinimumLength(trimmed)

        // Check Max Length
        throwExceptionIfOverMaxLength(trimmed)

        // Check For a Malformed EmailAddress Address
        throwExceptionIfEmailIsMalformed(trimmed)

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new EmailAddress(value)
    }

    private static void throwExceptionIfOverMaxLength(String value) {
        if(!isTrue(value.length() < MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }
    }

    private static void throwExceptionIfUnderMinimumLength(String value) {
        if(!isTrue(value.length() > MIN_LENGTH)) {
            throw new IllegalArgumentException("Param Value Was Below the Minimum length of ${MIN_LENGTH}.")
        }
    }

    private static void throwExceptionIfEmailIsMalformed(String value) {
        if(!"$value".matches(REGEX_MALFORMED_EMAIL)) {
            throw new IllegalArgumentException("Param Value was Malformed.")
        }
    }


}
