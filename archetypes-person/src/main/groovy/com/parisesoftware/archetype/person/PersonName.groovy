package com.parisesoftware.archetype.person

import static org.apache.commons.lang3.Validate.notNull

class PersonName {

    final FirstName firstName

    final LastName lastName

    protected PersonName(final FirstName firstName, final LastName lastName) {
        this.firstName = firstName
        this.lastName = lastName
    }

    /**
     * Factory Method to Handle Creation of new `PersonName` Immutable objects
     *
     * @param firstName the FirstName ValueObject to be associated with this name
     * @param lastName the LastName ValueObject to be associated with this name
     *
     * @return an Immutable PersonName object
     */
    static PersonName of(final FirstName firstName, final LastName lastName) {

        // verify the FirstName was not null
        notNull(firstName)

        // verify the LastName was not null
        notNull(lastName)

        return new PersonName(firstName, lastName)
    }

    String getName() {
        return "$firstName $lastName"
    }

}
