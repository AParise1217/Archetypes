package com.parisesoftware.archetype.party.address

import static org.apache.commons.lang3.Validate.notNull

/**
 * a Representation of a Number that can be used to reach a Phone, Pager, Fax, etc
 */
class TelecomAddress extends Address {

    final String areaCode

    final String number

    final String extension

    /**
     * the type of Device this TelecomAddress is for
     */
    final String physicalType

    protected TelecomAddress(final String areaCode, final String number, final String extension,
                             final String physicalType) {
        this.areaCode = areaCode
        this.number = number
        this.extension = extension
        this.physicalType = physicalType
    }

    static TelecomAddress of(final String areaCode, final String number, final String extension,
                             final String physicalType) {

        // verify the areaCode was not null
        notNull(areaCode, 'a TelecomAddress requires an Area Code value.')

        // verify the number was not null
        notNull(number, 'a TelecomAddress requires a Number value.')

        // verify the extension was not null
        notNull(extension, 'a TelecomAddress requires an Extension value.')

        // verify the physicalType was not null
        notNull(physicalType, 'a TelecomAddress requires a Physical Type.')

        return new TelecomAddress(areaCode, number, extension, physicalType)
    }

}
