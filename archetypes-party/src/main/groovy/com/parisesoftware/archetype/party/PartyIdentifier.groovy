package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.UniqueIdentifier
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class PartyIdentifier {

    UniqueIdentifier uniqueIdentifier

    static PartyIdentifier of(final UniqueIdentifier uniqueIdentifier) {

        // verify the UniqueIdentifier was not null
        notNull(uniqueIdentifier)

        return new PartyIdentifier(uniqueIdentifier: uniqueIdentifier)
    }

}
