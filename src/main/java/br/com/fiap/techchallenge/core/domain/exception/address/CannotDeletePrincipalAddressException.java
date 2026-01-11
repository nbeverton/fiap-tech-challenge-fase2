package br.com.fiap.techchallenge.core.domain.exception.address;

import java.util.List;

public class CannotDeletePrincipalAddressException extends RuntimeException {

    public CannotDeletePrincipalAddressException(
            String addressId,
            List<String> userIds
    ) {

        super(
            "It is not allowed to delete the address " + addressId
            + " because it is the primary address of the following users: "
            + String.join(", ", userIds)
        );
    }
}
