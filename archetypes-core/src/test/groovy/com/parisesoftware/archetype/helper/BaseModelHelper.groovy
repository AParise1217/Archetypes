package com.parisesoftware.archetype.helper

import com.parisesoftware.archetype.core.Name
import com.parisesoftware.archetype.core.UniqueIdentifier

final class BaseModelHelper {

    private BaseModelHelper() {}

    static UniqueIdentifier uniqueIdentifier() {
        return UniqueIdentifier.of('Some1d123')
    }

    static Name name() {
        return Name.of('Namey-McNameFace')
    }

}
