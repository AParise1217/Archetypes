package com.parisesoftware.model.helper.person

import com.parisesoftware.model.domain.person.FirstName
import com.parisesoftware.model.domain.person.LastName
import com.parisesoftware.model.domain.person.Person
import com.parisesoftware.model.domain.person.PersonName


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
