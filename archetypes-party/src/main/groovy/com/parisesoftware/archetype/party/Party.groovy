package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.party.address.Address

/**
 * Container of Rudimentary Semantics;
 *  Most Specifics are captured by {@link com.parisesoftware.archetype.person.Person},
 *      or subclasses of {@link com.parisesoftware.archetype.party.organization.Organization}
 */
abstract class Party {

    final PartyIdentifier partyIdentifier

    final List<Address> addresses

    final List<RegisteredIdentifier> registeredIdentifiers

    final List<PartyRole> partyRoles

    protected Party(final PartyIdentifier partyIdentifier,
                    final List<Address> addresses) {
        this.partyIdentifier = partyIdentifier
        this.addresses = addresses
        this.registeredIdentifiers = Collections.EMPTY_LIST
        this.partyRoles = Collections.EMPTY_LIST
    }

    protected Party(final PartyIdentifier partyIdentifier,
                    final List<Address> addresses,
                    final List<RegisteredIdentifier> registeredIdentifiers,
                    final List<PartyRole> partyRoles) {
        this.partyIdentifier = partyIdentifier
        this.addresses = addresses
        this.registeredIdentifiers = registeredIdentifiers
        this.partyRoles = partyRoles
    }

    PartyIdentifier getPartyIdentifier() {
        return this.partyIdentifier
    }

    /**
     * @return {@code String} the name of this Party
     */
    abstract String getName()

    List<RegisteredIdentifier> getRegisteredIdentifiers() {
        return this.registeredIdentifiers
    }

    List<Address> getAddresses() {
        return this.addresses
    }

    List<PartyRole> getRoles() {
        return this.partyRoles
    }

}
