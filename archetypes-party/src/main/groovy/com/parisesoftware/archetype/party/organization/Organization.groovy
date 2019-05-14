package com.parisesoftware.archetype.party.organization

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.party.Party
import com.parisesoftware.archetype.party.PartyIdentifier
import com.parisesoftware.archetype.party.address.Address

import static org.apache.commons.lang3.Validate.notEmpty
import static org.apache.commons.lang3.Validate.notNull

/**
 * an Administrative and Functional Structure
 */
class Organization extends Party {

    final OrganizationName organizationName

    final List<OrganizationName> otherOrganizationNames

    protected Organization(final PartyIdentifier partyIdentifier, final Name name, final List<Address> addresses) {
        super(partyIdentifier, addresses)

        this.organizationName = OrganizationName.of(name.value)
        this.otherOrganizationNames = []
    }

    OrganizationName getOrganizationName() {
        return this.organizationName
    }

    List<OrganizationName> getOtherOrganizationNames() {
        return this.otherOrganizationNames
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String getName() {
        return this.organizationName.name
    }

    static Organization of(final PartyIdentifier partyIdentifier, final Name name, final List<Address> addresses) {

        // verify the PartyIdentifier was not null
        notNull(partyIdentifier)

        // verify the Name was not null
        notNull(name)

        // verify the address list has at least one entry
        notEmpty(addresses)

        return new Organization(partyIdentifier, name,
                addresses)
    }

}
