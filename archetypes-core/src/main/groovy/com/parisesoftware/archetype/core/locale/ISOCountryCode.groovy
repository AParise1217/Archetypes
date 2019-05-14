package com.parisesoftware.archetype.core.locale

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.isTrue
import static org.apache.commons.lang3.Validate.notNull

/**
 * a Locale Representation of a Country
 * @version 1.0.0
 * @since 1.0.0
 */
class ISOCountryCode extends Locale {

    protected ISOCountryCode(final String alphabeticTwoCharacterCode, final String name, final String description) {
        super(alphabeticTwoCharacterCode, name, description)
    }

    String getShortName() {
        return this.name
    }

    String getAlphabeticTwoCharacterCode() {
        return this.identifier
    }

    static Locale of(final String alphabeticTwoCharacterCode, final String name, final String description) {

        // verify the identifier was not null
        notNull(alphabeticTwoCharacterCode, 'an ISOCountryCode must be instantiated with an identifier.')

        // validate that only two characters were provided
        isTrue(alphabeticTwoCharacterCode.size() == 2, 'an ISOCountryCode identifier must be exactly two characters long.')

        // verify the name was not null
        notNull(name, 'an ISOCountryCode must be instantiated with a name.')

        return new ISOCountryCode(alphabeticTwoCharacterCode, name, description)
    }

    static Locale of(final String alphabeticTwoCharacterCode, final String name) {
        return of(alphabeticTwoCharacterCode, name, StringUtils.EMPTY)
    }

}
