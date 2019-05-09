package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.core.UniqueIdentifier
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Party {

    UniqueIdentifier partyIdentifier

    Name name

    static Party of(final UniqueIdentifier partyIdentifier, final Name name) {

        // verify the UniqueIdentifier was not null
        notNull(partyIdentifier)

        // verify the Name was not null
        notNull(name)

        return new Party(name: name, partyIdentifier: partyIdentifier)
    }

}
