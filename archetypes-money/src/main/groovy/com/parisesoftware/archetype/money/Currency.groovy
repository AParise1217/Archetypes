package com.parisesoftware.archetype.money

import com.parisesoftware.archetype.core.Name

import static org.apache.commons.lang3.Validate.notNull

/**
 * A Generalized Notion of Currency
 */
class Currency {

    private Name name

    private String description

    private AlphabeticCode alphabeticCode

    private NumericCode numericCode

    private UnitSymbol majorUnitSymbol

    private UnitSymbol minorUnitSymbol

    /**
     * Factory Method to handle instantiation of new Currencies
     *
     * @param name the name of the Currency
     * @param description a Description of the Currency
     * @param alphabeticCode an Alphabetic Code that Represents the Currency
     * @param numericCode an Optional Numeric Code Assigned to the Currency
     * @param majorUnitSymbol the Symbol used to denote the Major Unit of Currency
     * @param minorUnitSymbol the Symbol used to denote the Minor Unit of Currency
     *
     * @return a fully instantiated Currency
     */
    static Currency of(final Name name, final String description = '',
                       final AlphabeticCode alphabeticCode, final NumericCode numericCode = NumericCode.of(null),
                       final UnitSymbol majorUnitSymbol, final UnitSymbol minorUnitSymbol = UnitSymbol.of(null)) {

        // verify the name was not null
        notNull(name)

        // verify the alphabeticCode was not null
        notNull(alphabeticCode)

        // verify the majorUnitSymbol was not null
        notNull(majorUnitSymbol)

        return new Currency(name: name, description: description,
                alphabeticCode: alphabeticCode, numericCode: numericCode,
                majorUnitSymbol: majorUnitSymbol, minorUnitSymbol: minorUnitSymbol)
    }

    String getName() {
        return this.name.value
    }

    String getSymbol() {
        return majorUnitSymbol.value.toString()
    }

}
