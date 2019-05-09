package com.parisesoftware.archetype.party.organization

import static org.apache.commons.lang3.Validate.notNull

/**
 * a Name to refer to a particular {@link Organization} by
 */
class OrganizationName {

    final String name

    protected OrganizationName(final String name) {
        this.name = name
    }

    static OrganizationName of(final String name) {

        // verify the value was not null
        notNull(name)

        return new OrganizationName(name)
    }

    String getName() {
        return this.name
    }

}
