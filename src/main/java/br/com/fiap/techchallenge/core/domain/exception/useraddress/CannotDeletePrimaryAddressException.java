package br.com.fiap.techchallenge.core.domain.exception.useraddress;

import java.util.List;

public class CannotDeletePrimaryAddressException extends RuntimeException {

    public CannotDeletePrimaryAddressException(
            String userAddressId,
            List<String> userIds) {

        super(
                "It is not allowed to delete the UserAddress (link) " + userAddressId
                + " because it is set as the primary address for the following users: "
                + String.join(", ", userIds)
        );
    }
}
