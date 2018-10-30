package com.parisesoftware.sample.domain

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Name {

    FirstName firstName

    LastName lastName

    /**
     * Factory Method to Handle Creation of new `Name` Immutable objects
     *
     * @param firstName the FirstName ValueObject to be associated with this name
     * @param lastName the LastName ValueObject to be associated with this name
     *
     * @return an Immutable Name object
     */
    static Name of(final FirstName firstName, final LastName lastName) {

        // verify the FirstName was not null
        notNull(firstName)

        // verify the LastName was not null
        notNull(lastName)

        return new Name(firstName: firstName, lastName: lastName)
    }

    String getName() {
        return "$firstName $lastName"
    }

}
