package com.parisesoftware.archetype.helper.money

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.money.AlphabeticCode
import com.parisesoftware.archetype.money.Money
import com.parisesoftware.archetype.money.NumericCode
import com.parisesoftware.archetype.money.Currency
import com.parisesoftware.archetype.money.UnitSymbol

final class MoneyModelHelper {

    private MoneyModelHelper() {}

    static Money money() {
        return Money.of(currency())
    }

    static Currency currency() {
        return Currency.of(name(), 'United States Dollar',
                alphabeticCode(), numericCode(),
                majorUnitSymbol(), minorUnitSymbol())
    }

    static Name name() {
        return Name.of('US Dollar')
    }

    static AlphabeticCode alphabeticCode() {
        return AlphabeticCode.of('USD')
    }

    static NumericCode numericCode() {
        return NumericCode.of('840')
    }

    static UnitSymbol majorUnitSymbol() {
        return UnitSymbol.of('$' as char)
    }

    static UnitSymbol minorUnitSymbol() {
        return UnitSymbol.of('¢' as char)
    }

}
