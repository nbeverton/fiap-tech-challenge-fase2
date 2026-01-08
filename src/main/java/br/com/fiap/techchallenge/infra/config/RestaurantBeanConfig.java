package br.com.fiap.techchallenge.infra.config;

import br.com.fiap.techchallenge.core.usecase.impl.restaurant.CreateRestaurantUseCaseImpl;
import br.com.fiap.techchallenge.core.usecase.impl.restaurant.DeleteRestaurantUseCaseImpl;
import br.com.fiap.techchallenge.core.usecase.impl.restaurant.FindRestaurantByIdUseCaseImpl;
import br.com.fiap.techchallenge.core.usecase.impl.restaurant.ListRestaurantsUseCaseImpl;
import br.com.fiap.techchallenge.core.usecase.impl.restaurant.UpdateRestaurantUseCaseImpl;

import br.com.fiap.techchallenge.core.usecase.in.restaurant.CreateRestaurantUseCase;
import br.com.fiap.techchallenge.core.usecase.in.restaurant.DeleteRestaurantUseCase;
import br.com.fiap.techchallenge.core.usecase.in.restaurant.FindRestaurantByIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.restaurant.ListRestaurantsUseCase;
import br.com.fiap.techchallenge.core.usecase.in.restaurant.UpdateRestaurantUseCase;

import br.com.fiap.techchallenge.core.usecase.out.RestaurantRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantBeanConfig {

    // ===================== Restaurant UseCases =====================

    @Bean
    public CreateRestaurantUseCase createRestaurantUseCase(
            RestaurantRepositoryPort restaurantRepository,
            UserRepositoryPort userRepository,
            AddressRepositoryPort addressRepository
    ) {
        return new CreateRestaurantUseCaseImpl(
                restaurantRepository,
                userRepository,
                addressRepository
        );
    }

    @Bean
    public UpdateRestaurantUseCase updateRestaurantUseCase(
            RestaurantRepositoryPort restaurantRepository,
            UserRepositoryPort userRepository,
            AddressRepositoryPort addressRepository
    ) {
        return new UpdateRestaurantUseCaseImpl(
                restaurantRepository,
                userRepository,
                addressRepository
        );
    }

    @Bean
    public DeleteRestaurantUseCase deleteRestaurantUseCase(RestaurantRepositoryPort repository) {
        return new DeleteRestaurantUseCaseImpl(repository);
    }

    @Bean
    public FindRestaurantByIdUseCase findRestaurantByIdUseCase(RestaurantRepositoryPort repository) {
        return new FindRestaurantByIdUseCaseImpl(repository);
    }

    @Bean
    public ListRestaurantsUseCase listRestaurantsUseCase(RestaurantRepositoryPort repository) {
        return new ListRestaurantsUseCaseImpl(repository);
    }

}

