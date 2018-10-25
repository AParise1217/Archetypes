package com.parisesoftware.sample.helper

import com.parisesoftware.sample.domain.FirstName
import com.parisesoftware.sample.domain.LastName
import com.parisesoftware.sample.domain.Name
import com.parisesoftware.sample.domain.User
import com.parisesoftware.sample.domain.UserId

final class ModelHelper {

    private ModelHelper() {}

    static User user() {
        return User.of(userId(), name())
    }

    static Name name() {
        return Name.of(firstName(), lastName())
    }

    static FirstName firstName() {
        return FirstName.of('firstName')
    }

    static LastName lastName() {
        return LastName.of('lastName')
    }

    static UserId userId() {
        return UserId.of('User1d123')
    }


}