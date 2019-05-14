package com.parisesoftware.archetype.core.locale

import org.apache.commons.lang3.StringUtils

import static org.apache.commons.lang3.Validate.notNull

/**
 * Representation of a place, location, or some context
 * @version 1.0.0
 * @since 1.0.0
 */
class Locale {

    /**
     * a unique identifier for the Locale
     */
    final String identifier

    /**
     * the Name of the Locale
     */
    final String name

    /**
     * an Optional, brief description of the Locale
     */
    final String description

    protected Locale(final String identifier, final String name, final String description) {
        this.identifier = identifier
        this.name = name
        this.description = description
    }

    static Locale of(final String identifier, String name) {

        // verify the identifier was not null
        notNull(identifier)

        // verify the name was not null
        notNull(name)

        return new Locale(identifier, name, StringUtils.EMPTY)
    }

    static Locale of(final String identifier, final String name, final String description) {

        // verify the identifier was not null
        notNull(identifier)

        // verify the name was not null
        notNull(name)

        return new Locale(identifier, name, description)
    }

}
