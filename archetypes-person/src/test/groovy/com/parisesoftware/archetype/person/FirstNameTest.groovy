package com.parisesoftware.archetype.person

import spock.lang.Specification

import static org.apache.commons.lang3.StringUtils.repeat
import static org.apache.commons.lang3.StringUtils.trim

class FirstNameTest extends Specification {

    def "Value Should be Trimmed"() {
        given: "a Value with trailing whitespace"
            def expectedValue = 'Andrew'
            def testUntrimmedValue = "      $expectedValue           "

        when: "the First PersonName Factory Method is Invoked"
            final firstName = FirstName.of(testUntrimmedValue)

        then: "the value is trimmed"
            trim(testUntrimmedValue) == firstName.value
    }

    def "Value Just Under Max Length Should not throw IllegalArgumentException Exception"() {
        given: "a Value exceeding the Max Value"
            def bigTestValue = repeat('a', FirstName.MAX_LENGTH - 1)

        when: "the First PersonName Factory Method is Invoked"
            FirstName.of(bigTestValue)

        then: "no Exceptions are thrown"
            noExceptionThrown()
    }

    def "Value Exceeding Max Length Should not throw IllegalArgumentException Exception"() {
        given: "a Value exceeding the Max Value"
            def bigTestValue = repeat('a', FirstName.MAX_LENGTH + 1)

        when: "the First PersonName Factory Method is Invoked"
            FirstName.of(bigTestValue)

        then: "an IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)
    }

    def "Blank Value Should throw IllegalArgumentException Exception"() {
        given: "a Value that is blank"
            def blankTestValue = ''

        when: "the First PersonName Factory Method is Invoked"
            FirstName.of(blankTestValue)

        then: "an IllegalArgumentException is thrown"
            thrown(IllegalArgumentException)
    }

    def "Whitespace Value Should throw IllegalArgumentException Exception"() {
        given: "a Value that is a bunch of spaces"
            def blankTestValue = '    '

        when: "the First PersonName Factory Method is Invoked"
            FirstName.of(blankTestValue)

        then: "an IllegalArgumentException is thrown"
            thrown(IllegalArgumentException)
    }




}
