package com.parisesoftware.model.domain

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class UniqueIdentifier {

    String identifier

    static UniqueIdentifier of(final String identifier) {

        // verify the identifier was not null
        notNull(identifier)

        return new UniqueIdentifier(identifier: identifier)
    }

}
