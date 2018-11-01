package com.parisesoftware.model.helper

import com.parisesoftware.model.domain.Name
import com.parisesoftware.model.domain.UniqueIdentifier

final class BaseModelHelper {

    private BaseModelHelper() {}

    static UniqueIdentifier uniqueIdentifier() {
        return UniqueIdentifier.of('Some1d123')
    }

    static Name name() {
        return Name.of('Namey-McNameFace')
    }

}
