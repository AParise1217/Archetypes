package com.parisesoftware.sample.helper

import com.parisesoftware.sample.domain.money.AlphabeticCode
import com.parisesoftware.sample.domain.money.Currency
import com.parisesoftware.sample.domain.money.Money
import com.parisesoftware.sample.domain.money.Name
import com.parisesoftware.sample.domain.money.NumericCode
import com.parisesoftware.sample.domain.money.UnitSymbol

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
        return Name.of('US Dollars')
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
