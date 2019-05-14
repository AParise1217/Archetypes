package com.parisesoftware.archetype.party

import com.parisesoftware.archetype.core.UniqueIdentifier

import static org.apache.commons.lang3.Validate.notBlank

/**
 * a System Generated Unique Identifier for a {@link Party}
 */
class PartyIdentifier extends UniqueIdentifier {

    final String uniqueIdentifier

    protected PartyIdentifier(final String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier
    }

    static PartyIdentifier of(final String uniqueIdentifier) {

        // verify the UniqueIdentifier was not null
        notBlank(uniqueIdentifier)

        return new PartyIdentifier(uniqueIdentifier)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String getIdentifier() {
        return this.uniqueIdentifier
    }

}
