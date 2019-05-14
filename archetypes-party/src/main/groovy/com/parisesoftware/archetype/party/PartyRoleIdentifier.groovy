package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.UniqueIdentifier

import static org.apache.commons.lang3.Validate.notNull

/**
 * a System Generated Unique Identifier for a {@link PartyRole}
 */
class PartyRoleIdentifier {

    final UniqueIdentifier uniqueIdentifier

    protected PartyRoleIdentifier(final UniqueIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier
    }

    static PartyRoleIdentifier of(final UniqueIdentifier uniqueIdentifier) {

        // verify the UniqueIdentifier was not null
        notNull(uniqueIdentifier)

        return new PartyRoleIdentifier(uniqueIdentifier)
    }

}
