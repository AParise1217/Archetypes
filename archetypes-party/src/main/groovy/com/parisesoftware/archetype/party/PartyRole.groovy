package com.parisesoftware.archetype.party

import static org.apache.commons.lang3.Validate.notNull

/**
 * Captures the Semantics of the role played by a {@link Party},
 *  in a particular {@link PartyRelationship}.
 *
 * This should not be used to capture information about the {@link Party} or {@link PartyRelationship}.
 */
class PartyRole {

    final String name

    final String description

    final Party party

    final PartyRoleIdentifier partyRoleIdentifier

    protected PartyRole(final PartyRoleIdentifier partyRoleIdentifier,
                        final String name, final String description, final Party party) {
        this.name = name
        this.description = description
        this.party = party
        this.partyRoleIdentifier = partyRoleIdentifier
    }

    String getName() {
        return this.name
    }

    String getDescription() {
        return this.description
    }

    Party getParty() {
        return this.party
    }

    PartyRoleIdentifier getIdentifier() {
        return this.partyRoleIdentifier
    }

    static PartyRole of(final PartyRoleIdentifier partyRoleIdentifier,
                        final String name, final String description, final Party party) {
        notNull(partyRoleIdentifier, 'a PartyRole must be associated with a valid PartyRoleIdentifier.')
        notNull(party, 'a PartyRole must be associated with a valid Party.')

        return new PartyRole(partyRoleIdentifier, name, description, party)
    }

}
