package br.com.fiap.techchallenge.infra.web.mapper.address;

import br.com.fiap.techchallenge.core.domain.model.Address;
import br.com.fiap.techchallenge.infra.web.dto.address.AddressResponse;
import br.com.fiap.techchallenge.infra.web.dto.address.CreateAddressRequest;
import br.com.fiap.techchallenge.infra.web.dto.address.UpdateAddressRequest;

public class AddressDtoMapper {

    public static Address toDomain(CreateAddressRequest request){

        return new Address(
                request.postalCode(),
                request.streetName(),
                request.streetNumber(),
                request.additionalInfo(),
                request.neighborhood(),
                request.city(),
                request.stateProvince(),
                request.country()
        );
    }

    public static Address toDomain(UpdateAddressRequest request){

        return new Address(
                request.postalCode(),
                request.streetName(),
                request.streetNumber(),
                request.additionalInfo(),
                request.neighborhood(),
                request.city(),
                request.stateProvince(),
                request.country()
        );
    }

    public static Address toResponse(AddressResponse response){

        return new Address(
                response.id(),
                response.postalCode(),
                response.streetName(),
                response.streetNumber(),
                response.additionalInfo(),
                response.neighborhood(),
                response.city(),
                response.stateProvince(),
                response.country()
        );
    }
}
