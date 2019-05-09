package com.parisesoftware.archetype.party

/**
 * an identifier for a {@link Party} that was assigned by some recognized body or organization
 *
 *  Note: this is not necessarily unique, thus it is different from
 *      {@link com.parisesoftware.archetype.core.UniqueIdentifier}
 */
class RegisteredIdentifier {

    String identifier

    String registrationAuthority

}
