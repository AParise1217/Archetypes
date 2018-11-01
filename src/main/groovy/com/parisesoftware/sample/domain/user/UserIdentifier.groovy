package com.parisesoftware.sample.domain.user

import com.parisesoftware.model.domain.UniqueIdentifier
import groovy.transform.Immutable
import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.BooleanUtils.isTrue
import static org.apache.commons.lang3.StringUtils.trim
import static org.apache.commons.lang3.Validate.notBlank

@Immutable
class UserIdentifier {

    private static final String REGEX_INVALID_STARTING_CHARACTER = '^[a-zA-Z].*'
    private static final String REGEX_CONTAINS_INVALID_CHARACTER = '^[a-zA-Z0-9._-]+$'

    protected static final int MIN_LENGTH = 3
    protected static final int MAX_LENGTH = 36

    UniqueIdentifier uniqueIdentifier

    /**
     * Factory Method to handle Construction of `UserIdentifier` Immutable Objects
     * <b>Note:</b> This does not handle verifying if the UserIdentifier is already in use
     *
     * @param value the Value to be encapsulated
     * @return an Immutable User Id
     */
    static UserIdentifier of(final UniqueIdentifier uniqueIdentifier) {

        String value = uniqueIdentifier.identifier

        // Check for a Blank Value
        notBlank(value)

        final String trimmed = trim(value)

        // Check Minimum Length
        throwExceptionIfUnderMinimumLength(trimmed)

        // Check Max Length
        throwExceptionIfOverMaxLength(trimmed)

        // Check For Invalid Starting Character
        throwExceptionIfInvalidStartingCharacter(trimmed)

        // Check For Invalid Characters
        throwExceptionIfContainsInvalidCharacter(trimmed)

        // if the Value was Trimmed, and within the bounds,
        // then invoked again to be sure all validation rules were hit
        if (!StringUtils.equals(value, trimmed)) {
            return of(trimmed)
        }

        return new UserIdentifier(value)
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

    private static void throwExceptionIfInvalidStartingCharacter(String value) {
        if(!"$value".matches(REGEX_INVALID_STARTING_CHARACTER)) {
            throw new IllegalArgumentException("Param Value's Starting Character was invalid.")
        }
    }

    private static void throwExceptionIfContainsInvalidCharacter(String value) {
        if (!"$value".matches(REGEX_CONTAINS_INVALID_CHARACTER)) {
            throw new IllegalArgumentException("Param Value Contained an invalid Character.")
        }
    }


}
