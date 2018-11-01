package com.parisesoftware.sample.helper.user

import com.parisesoftware.model.domain.UniqueIdentifier
import com.parisesoftware.sample.domain.user.User
import com.parisesoftware.sample.domain.user.UserIdentifier

import static com.parisesoftware.model.helper.person.PersonModelHelper.person

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
