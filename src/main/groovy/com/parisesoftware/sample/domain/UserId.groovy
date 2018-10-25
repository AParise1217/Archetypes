package com.parisesoftware.sample.domain

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class UserId {

    private static final String REGEX_INVALID_STARTING_CHARACTER = '^[a-zA-Z].*'
    private static final String REGEX_CONTAINS_INVALID_CHARACTER = '^[a-zA-Z0-9._-]+$'

    protected static final int MIN_LENGTH = 3
    protected static final int MAX_LENGTH = 36

    String value

    /**
     * Factory Method to handle Construction of `UserId` Immutable Objects
     * <b>Note:</b> This does not handle verifying if the UserId is already in use
     *
     * @param value the Value to be encapsulated
     * @return an Immutable User Id
     */
    static UserId of(String value) {

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

        // Check For Invalid Starting Character
        if(!"$value".matches(REGEX_INVALID_STARTING_CHARACTER)) {
            throw new IllegalArgumentException("Param Value's Starting Character was invalid.")
        }

        // Check For Invalid Characters
        if (!"$value".matches(REGEX_CONTAINS_INVALID_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Contained an invalid Character.")
        }

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new UserId(value)
    }


}
