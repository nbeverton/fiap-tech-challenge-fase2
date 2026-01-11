package br.com.fiap.techchallenge.core.domain.exception.address;

public class CannotDeletePrincipalAddressException extends RuntimeException {

    public CannotDeletePrincipalAddressException(String addressId) {

        super(
            "It is not allowed to delete the address "
            + addressId
            + " because it is set as the primary address of a user."
        );
    }
}
