package br.com.fiap.techchallenge.infra.config;

import br.com.fiap.techchallenge.core.usecase.impl.address.*;
import br.com.fiap.techchallenge.core.usecase.in.address.*;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressBeanConfig {

    @Bean
    public CreateAddressUseCase createAddressUseCase(AddressRepositoryPort repository){

        return new CreateAddressUseCaseImpl(repository);
    }

    @Bean
    public FindAddressByIdUseCase findAddressByIdUseCase(AddressRepositoryPort repository){

        return new FindAddressByIdUseCaseImpl(repository);
    }

    @Bean
    public FindAllAddressUseCase findAllAddressUseCase(AddressRepositoryPort repository){

        return new FindAllAddressUseCaseImpl(repository);
    }

    @Bean
    public UpdateAddressUseCase updateAddressUseCase(AddressRepositoryPort repository){

        return new UpdateAddressUseCaseImpl(repository);
    }

    @Bean
    public DeleteAddressUseCase deleteAddressUseCase(
            AddressRepositoryPort addressRepository,
            UserAddressRepositoryPort userAddressRepository
    ){

        return new DeleteAddressUseCaseImpl(
                addressRepository,
                userAddressRepository
        );
    }

}
