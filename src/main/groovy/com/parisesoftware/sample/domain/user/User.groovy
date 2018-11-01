package com.parisesoftware.sample.domain.user

import com.parisesoftware.model.domain.person.Person
import groovy.transform.Immutable

import static org.apache.commons.lang3.Validate.notNull

@Immutable
class User {

    UserIdentifier userId

    Person person

    /**
     * Factory Method to Handle Creation of new `User` Immutable objects
     *
     * @param userId the Unique Identifier Value Object to be associated with this User
     * @param name the PersonName Value Object to be associated with this User
     *
     * @return an Immutable User object
     */
    static User of(final UserIdentifier userId, final Person person) {

        // verify the UserID was not null
        notNull(userId)

        // verify the Person was not null
        notNull(person)

        return new User(userId: userId, person: person)
    }

}
