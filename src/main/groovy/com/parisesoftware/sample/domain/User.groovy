package com.parisesoftware.sample.domain

import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class User {

    UserId userId

    Name name

    /**
     * Factory Method to Handle Creation of new `User` Immutable objects
     *
     * @param userId
     * @param name
     * @return an Immutable User object
     */
    static User of(final UserId userId, final Name name) {

        // verify the UserID was not null
        notNull(userId)

        // verify the Name was not null
        notNull(name)

        return new User(userId: userId, name: name)
    }

}
