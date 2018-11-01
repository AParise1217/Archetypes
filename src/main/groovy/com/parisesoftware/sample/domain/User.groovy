package com.parisesoftware.sample.domain


import com.parisesoftware.sample.domain.person.PersonName
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class User {

    UserId userId

    PersonName name

    /**
     * Factory Method to Handle Creation of new `User` Immutable objects
     *
     * @param userId the Unique Identifier Value Object to be associated with this User
     * @param name the PersonName Value Object to be associated with this User
     *
     * @return an Immutable User object
     */
    static User of(final UserId userId, final PersonName name) {

        // verify the UserID was not null
        notNull(userId)

        // verify the PersonName was not null
        notNull(name)

        return new User(userId: userId, name: name)
    }

}
