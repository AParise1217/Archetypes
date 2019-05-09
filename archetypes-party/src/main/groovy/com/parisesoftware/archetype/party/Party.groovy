package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.core.UniqueIdentifier
import com.parisesoftware.archetype.party.address.Address
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notEmpty
import static org.apache.commons.lang3.Validate.notNull

class Party {

    final PartyIdentifier partyIdentifier

    final Name name

    final List<Address> addresses

    final List<RegisteredIdentifier> registeredIdentifiers

    protected Party(final PartyIdentifier partyIdentifier, final Name name,
                    final List<Address> addresses) {
        this.partyIdentifier = partyIdentifier
        this.name = name
        this.addresses = addresses
        this.registeredIdentifiers = Collections.EMPTY_LIST
    }

    protected Party(final PartyIdentifier partyIdentifier, final Name name,
                    final List<Address> addresses,
                    final List<RegisteredIdentifier> registeredIdentifiers) {
        this.partyIdentifier = partyIdentifier
        this.name = name
        this.addresses = addresses
        this.registeredIdentifiers = registeredIdentifiers
    }

    static Party of(final PartyIdentifier partyIdentifier, final Name name, final List<Address> addresses) {

        // verify the UniqueIdentifier was not null
        notNull(partyIdentifier)

        // verify the Name was not null
        notNull(name)

        // verify the address list has at least one entry
        notEmpty(addresses)

        return new Party(partyIdentifier, name,
                addresses)
    }

    PartyIdentifier getPartyIdentifier() {
        return this.partyIdentifier
    }

    String getName() {
        return this.name.value
    }

    List<RegisteredIdentifier> getRegisteredIdentifiers() {
        return this.registeredIdentifiers
    }

    List<Address> getAddresses() {
        return this.addresses
    }

}
