package com.parisesoftware.archetype.person

import static org.apache.commons.lang3.Validate.notNull

class Person {

    final PersonName personName

    protected Person(final PersonName personName) {
        this.personName = personName
    }

    static Person of(final PersonName personName) {

        // Check for a null personName
        notNull(personName)

        return new Person(personName)
    }

    String getName() {
        return personName.name
    }

}
