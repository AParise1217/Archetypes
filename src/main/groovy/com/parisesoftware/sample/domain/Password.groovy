package com.parisesoftware.sample.domain

import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class Password {

    private static final String REGEX_CONTAINS_LOWERCASE_CHARACTER = '.*[a-z].*'
    private static final String REGEX_CONTAINS_UPPERCASE_CHARACTER = '.*[A-Z].*'
    private static final String REGEX_CONTAINS_NUMERICAL_CHARACTER = '.*[0-9].*'
    private static final String REGEX_CONTAINS_WHITESPACE = /.*\s.*/

    protected static final int MIN_LENGTH = 8
    protected static final int MAX_LENGTH = 255

    String value

    /**
     * Factory Method to handle Construction of `Password` Immutable Objects
     * <b>Note:</b> This does not handle verifying if the Password has already been used,
     *              or if it contains a Special Character
     *
     * @param value the Value to be encapsulated
     * @return an Immutable Password
     */
    static Password of(String value) {

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

        // Check For Containing Lowercase Character
        if(!"$value".matches(REGEX_CONTAINS_LOWERCASE_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain a Lowercase Character.")
        }

        // Check For Containing Uppercase Character
        if(!"$value".matches(REGEX_CONTAINS_UPPERCASE_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain an Uppercase Character.")
        }

        // Check For Containing Numerical Character
        if(!"$value".matches(REGEX_CONTAINS_NUMERICAL_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain a Numerical Character.")
        }

        // Check For Containing Whitespace
        if (!"$value".matches(REGEX_CONTAINS_WHITESPACE)) {
            throw new IllegalArgumentException("Param Value Contained Whitespace Characters.")
        }

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new Password(value)
    }


}
