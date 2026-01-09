package br.com.fiap.techchallenge.infra.web.mapper.useraddress;

import br.com.fiap.techchallenge.core.usecase.out.UserAddressSummaryOutput;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.UserAddressSummaryResponse;

public class UserAddressSummaryDtoMapper {

    private UserAddressSummaryDtoMapper(){}


    public static UserAddressSummaryResponse toResponse(
            UserAddressSummaryOutput output
    ){

        return new UserAddressSummaryResponse(
                output.addressType().name(),
                output.streetName(),
                output.streetNumber(),
                output.neighborhood(),
                output.city(),
                output.stateProvince(),
                output.additionalInfo(),
                output.principal()
        );
    }
}
