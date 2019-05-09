package com.parisesoftware.archetype.party.address

import com.parisesoftware.archetype.core.locale.Locale

import static org.apache.commons.lang3.Validate.notBlank
import static org.apache.commons.lang3.Validate.notEmpty
import static org.apache.commons.lang3.Validate.notNull

/**
 * a Geographic Location at which a {@link com.parisesoftware.archetype.party.Party} may be contacted.
 *  the Postal Address for a Party
 */
class GeographicAddress extends Address {

    final List<String> addressLine

    final String city

    final String regionOrState

    final String zipOrPostalCode

    final Locale locale

    protected GeographicAddress(final List<String> addressLine, final String city,
                                final String regionOrState, final String zipOrPostalCode, final Locale locale) {
        this.addressLine = addressLine
        this.city = city
        this.regionOrState = regionOrState
        this.zipOrPostalCode = zipOrPostalCode
        this.locale = locale
    }

    Locale getCountry() {
        return this.locale
    }

    /**
     * Factory Method to handle Construction of `EmailAddress` Immutable Objects
     *
     * @param value the Value to be encapsulated
     * @return an Immutable EmailAddress
     */
    static GeographicAddress of(final List<String> addressLine, final String city,
                                final String regionOrState, final String zipOrPostalCode, final Locale locale) {

        // verify the address lines were provided
        notEmpty(addressLine)

        // verify there was a provided city
        notBlank(city)

        // verify there was a provided region or state
        notBlank(regionOrState)

        // verify there was a provided zip or postal code
        notBlank(zipOrPostalCode)

        // verify the locale was not null
        notNull(locale)

        return new GeographicAddress(addressLine, city, regionOrState, zipOrPostalCode, locale)
    }

}
