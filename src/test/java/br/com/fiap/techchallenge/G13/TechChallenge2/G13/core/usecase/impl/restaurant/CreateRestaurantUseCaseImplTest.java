package br.com.fiap.techchallenge.G13.TechChallenge2.G13.core.usecase.impl.restaurant;

import br.com.fiap.techchallenge.core.domain.model.Address;
import br.com.fiap.techchallenge.core.domain.model.Restaurant;
import br.com.fiap.techchallenge.core.domain.model.User;
import br.com.fiap.techchallenge.core.usecase.impl.restaurant.CreateRestaurantUseCaseImpl;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.RestaurantRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CreateRestaurantUseCaseImplTest {

    @InjectMocks
    private CreateRestaurantUseCaseImpl createRestaurantUseCase;

    @Mock
    private RestaurantRepositoryPort restaurantRepository;

    @Mock
    private UserRepositoryPort userRepository;

    @Mock
    private AddressRepositoryPort addressRepository;

    private User u;
    private Address a;
    private Restaurant r;

    @BeforeEach
    void setUp() {

    }


    @Test
    void testCreateRestaurant_Success() {

    }

}
