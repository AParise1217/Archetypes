package com.parisesoftware.sample.helper

import com.parisesoftware.sample.domain.person.FirstName
import com.parisesoftware.sample.domain.person.LastName
import com.parisesoftware.sample.domain.person.Person
import com.parisesoftware.sample.domain.person.PersonName
import com.parisesoftware.sample.domain.User
import com.parisesoftware.sample.domain.UserId

final class PersonModelHelper {

    private PersonModelHelper() {}

    static Person person() {
        return Person.of(personName())
    }

    static PersonName personName() {
        return PersonName.of(firstName(), lastName())
    }

    static FirstName firstName() {
        return FirstName.of('firstName')
    }

    static LastName lastName() {
        return LastName.of('lastName')
    }

}
