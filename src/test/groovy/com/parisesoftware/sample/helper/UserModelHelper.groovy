package com.parisesoftware.sample.helper

import com.parisesoftware.sample.domain.User
import com.parisesoftware.sample.domain.UserId

import static com.parisesoftware.sample.helper.PersonModelHelper.personName

final class UserModelHelper {

    private UserModelHelper() {}

    static User user() {
        return User.of(userId(), personName())
    }

    static UserId userId() {
        return UserId.of('User1d123')
    }

}
