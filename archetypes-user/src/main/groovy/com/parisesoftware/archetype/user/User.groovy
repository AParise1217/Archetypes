package com.parisesoftware.archetype.user

import com.parisesoftware.archetype.person.Person

import static org.apache.commons.lang3.Validate.notNull

class User {

    final UserIdentifier userId

    final Person person

    protected User(final UserIdentifier userId, final Person person) {
        this.userId = userId
        this.person = person
    }

    /**
     * Factory Method to Handle Creation of new `User` Immutable objects
     *
     * @param userId the Unique Identifier Value Object to be associated with this User
     * @param person the person Value Object to be associated with this User
     *
     * @return an Immutable User object
     */
    static User of(final UserIdentifier userId, final Person person) {

        // verify the UserID was not null
        notNull(userId)

        // verify the Person was not null
        notNull(person)

        return new User(userId, person)
    }

}
