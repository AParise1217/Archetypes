package com.parisesoftware.model.domain.quantity.exception

import com.parisesoftware.model.domain.exception.TypeMismatchException

class MetricTypeMismatchException extends TypeMismatchException {

    MetricTypeMismatchException() {
        super('Both the target and parameter Quantity Objects must be in the same Metric.')
    }

}
