package com.parisesoftware.archetype.party.company

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.party.PartyIdentifier
import com.parisesoftware.archetype.party.address.Address
import com.parisesoftware.archetype.party.organization.Organization

import static org.apache.commons.lang3.Validate.notEmpty
import static org.apache.commons.lang3.Validate.notNull

/**
 * an Organization with a legal identity separate from its owners
 */
class Company extends Organization {

    protected Company(PartyIdentifier partyIdentifier, Name name, List<Address> addresses) {
        super(partyIdentifier, name, addresses)
    }

    static Company of(final PartyIdentifier partyIdentifier, final Name name, final List<Address> addresses) {

        // verify the UniqueIdentifier was not null
        notNull(partyIdentifier)

        // verify the Name was not null
        notNull(name)

        // verify the address list has at least one entry
        notEmpty(addresses)

        return new Company(partyIdentifier, name,
                addresses)
    }

}
