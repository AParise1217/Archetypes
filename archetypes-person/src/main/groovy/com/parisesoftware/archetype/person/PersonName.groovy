package com.parisesoftware.archetype.person

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class PersonName {

    FirstName firstName

    LastName lastName

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

        return new PersonName(firstName: firstName, lastName: lastName)
    }

    String getName() {
        return "$firstName $lastName"
    }

}
