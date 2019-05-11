package com.parisesoftware.archetype.money.exception

class NotMeaningfulOperationException extends RuntimeException {

    NotMeaningfulOperationException() {
        super('The requested operation was not meaningful, and therefore has not been implemented.')
    }

}
