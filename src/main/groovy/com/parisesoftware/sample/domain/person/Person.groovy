package com.parisesoftware.sample.domain.person

import groovy.transform.Immutable
import static org.apache.commons.lang3.Validate.notNull

@Immutable
class Person {

    PersonName personName

    static Person of(final PersonName personName) {

        // Check for a null personName
        notNull(personName)

        return new Person(personName: personName)
    }

    String getName() {
        return personName.name
    }
}
