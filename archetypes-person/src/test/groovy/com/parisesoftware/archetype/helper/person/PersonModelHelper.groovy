package com.parisesoftware.archetype.helper.person

import com.parisesoftware.archetype.person.FirstName
import com.parisesoftware.archetype.person.LastName
import com.parisesoftware.archetype.person.Person
import com.parisesoftware.archetype.person.PersonName

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
