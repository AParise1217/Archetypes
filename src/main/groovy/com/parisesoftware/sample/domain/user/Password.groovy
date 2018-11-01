package com.parisesoftware.sample.domain.user

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
     *
     * @param value the Value to be encapsulated
     *
     * @return an Immutable Password
     */
    static Password of(final String value) {

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)

        // Check Minimum Length
        throwExceptionIfUnderMinimumLength(trimmed)

        // Check Max Length
        throwExceptionIfOverMaximumLength(trimmed)

        // Check For Containing Lowercase Character
        throwExceptionIfNoLowercaseCharacter(trimmed)

        // Check For Containing Uppercase Character
        throwExceptionIfNoUppercaseCharacter(trimmed)

        // Check For Containing Numerical Character
        throwExceptionIfNoNumericalCharacter(trimmed)

        // Check For Containing Whitespace
        throwExceptionIfContainsWhitespace(value)

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new Password(value)
    }

    private static void throwExceptionIfContainsWhitespace(String value) {
        if (!"$value".matches(REGEX_CONTAINS_WHITESPACE)) {
            throw new IllegalArgumentException("Param Value Contained Whitespace Characters.")
        }
    }

    private static void throwExceptionIfNoUppercaseCharacter(String value) {
        if(!"$value".matches(REGEX_CONTAINS_UPPERCASE_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain an Uppercase Character.")
        }
    }

    private static void throwExceptionIfNoLowercaseCharacter(String value) {
        if(!"$value".matches(REGEX_CONTAINS_LOWERCASE_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain a Lowercase Character.")
        }
    }

    private static void throwExceptionIfNoNumericalCharacter(String value) {
        if(!"$value".matches(REGEX_CONTAINS_NUMERICAL_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Must Contain a Numerical Character.")
        }
    }

    private static void throwExceptionIfUnderMinimumLength(String value) {
        if(!isTrue(value.length() > MIN_LENGTH)) {
            throw new IllegalArgumentException("Param Value Was Below the Minimum length of ${MIN_LENGTH}.")
        }
    }

    private static void throwExceptionIfOverMaximumLength(String value) {
        if(!isTrue(value.length() < MAX_LENGTH)) {
            throw new IllegalArgumentException("Param Value Exceeded the Maximum length of ${MAX_LENGTH}.")
        }
    }

}
