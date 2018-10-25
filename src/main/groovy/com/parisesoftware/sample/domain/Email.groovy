package com.parisesoftware.sample.domain

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class Email {

    private static final String REGEX_MALFORMED_EMAIL = '^[a-zA-Z0-9_!#$%&\'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.][a-zA-Z0-9.-]+$'

    protected static final int MIN_LENGTH = 5
    protected static final int MAX_LENGTH = 256

    String value

    /**
     * Factory Method to handle Construction of `Email` Immutable Objects
     * <b>Note:</b> This does not handle verifying if the Email is already in use
     *
     * @param value the Value to be encapsulated
     * @return an Immutable Email
     */
    static Email of(String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)

        // Check Minimum Length
        if(!isTrue(trimmed.length() > MIN_LENGTH)) {
            throw new IllegalArgumentException("Param Value Was Below the Minimum length of ${MIN_LENGTH}.")
        }

        // Check Max Length
        if(!isTrue(trimmed.length() < MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }

        // Check For a Malformed Email Address
        if(!"$value".matches(REGEX_MALFORMED_EMAIL)) {
            throw new IllegalArgumentException("Param Value was Malformed.")
        }

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new Email(value)
    }


}
