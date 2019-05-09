package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.UniqueIdentifier
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

/**
 * a System Generated Unique Identifier
 */
class PartyIdentifier {

    final UniqueIdentifier uniqueIdentifier

    protected PartyIdentifier(final UniqueIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier
    }

    static PartyIdentifier of(final UniqueIdentifier uniqueIdentifier) {

        // verify the UniqueIdentifier was not null
        notNull(uniqueIdentifier)

        return new PartyIdentifier(uniqueIdentifier: uniqueIdentifier)
    }

}
