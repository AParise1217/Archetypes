package com.parisesoftware.archetype.helper.user

import com.parisesoftware.archetype.core.UniqueIdentifier
import com.parisesoftware.archetype.user.User
import com.parisesoftware.archetype.user.UserIdentifier

final class UserModelHelper {

    private UserModelHelper() {}

    static User user() {
        return User.of(userIdentifier(), person())
    }

    static UserIdentifier userIdentifier() {
        return UserIdentifier.of(uniqueIdentifier())
    }

    static UniqueIdentifier uniqueIdentifier() {
        return UniqueIdentifier.of('User1d123')
    }

}
