package com.parisesoftware.archetype.core

import static org.apache.commons.lang3.Validate.notNull

class UniqueIdentifier {

    final String identifier

    protected UniqueIdentifier(final String identifier) {
        this.identifier = identifier
    }

    static UniqueIdentifier of(final String identifier) {

        // verify the identifier was not null
        notNull(identifier)

        return new UniqueIdentifier(identifier)
    }

}
