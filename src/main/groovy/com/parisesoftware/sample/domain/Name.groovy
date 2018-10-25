package com.parisesoftware.sample.domain

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Name {

    private FirstName firstName

    private LastName lastName

    /**
     * Factory Method to Handle Creation of new `Name` Immutable objects
     * @param userId
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
