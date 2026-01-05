package br.com.fiap.techchallenge.core.usecase.impl.restaurant;

import br.com.fiap.techchallenge.core.domain.enums.UserType;
import br.com.fiap.techchallenge.core.domain.exception.BusinessException;
import br.com.fiap.techchallenge.core.domain.exception.user.UserNotFoundException;
import br.com.fiap.techchallenge.core.domain.model.Restaurant;
import br.com.fiap.techchallenge.core.domain.model.User;
import br.com.fiap.techchallenge.core.usecase.in.restaurant.CreateRestaurantUseCase;
import br.com.fiap.techchallenge.core.usecase.out.RestaurantRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserRepositoryPort;

public class CreateRestaurantUseCaseImpl implements CreateRestaurantUseCase {

    private final RestaurantRepositoryPort restaurantRepository;
    private final UserRepositoryPort userRepository;

    public CreateRestaurantUseCaseImpl(
            RestaurantRepositoryPort restaurantRepository,
            UserRepositoryPort userRepository
    ) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Restaurant execute(Restaurant restaurant) {

        if (restaurant.getUserId() == null) {
            throw new BusinessException("User not informed");
        }

        User owner = userRepository.findById(restaurant.getUserId())
                .orElseThrow(() ->
                        new UserNotFoundException("User not informed")
                );

        if (owner.getUserType() != UserType.OWNER) {
            throw new BusinessException(
                    "Only OWNER-type users can create restaurants"
            );
        }

        restaurantRepository.findByAddressId(restaurant.getAddressId())
                .ifPresent(r -> {
                    throw new BusinessException(
                            "This address is already linked to another restaurant"
                    );
                });

        return restaurantRepository.save(restaurant);
    }
}
