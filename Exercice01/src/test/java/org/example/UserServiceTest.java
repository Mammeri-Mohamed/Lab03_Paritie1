package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserRepository mockUserRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Création d'un mock pour UserRepository avant chaque test
        mockUserRepository = mock(UserRepository.class);
        // Création d'une instance de UserService avec le mock
        userService = new UserService(mockUserRepository);
    }

    @Test
    public void testGetUserById() {
        // 1-* Création d'un user
        User expectedUser = new User(1L, "Mammeri_Mohamed", "mammerim3@gmail.com");


        //2-* Configuration du comportement du mock
        when(mockUserRepository.findUserById(1L)).thenReturn(expectedUser);

        // 3-* Appel de la méthode
        User resultUser = userService.getUserById(1L);

        // 4-* Vérification que la méthode findUserById a été appelée avec le bon argument
        verify(mockUserRepository).findUserById(1L);


        // Assertions
        Assertions.assertEquals(expectedUser, resultUser, "L'utilisateur retourné doit être égal à l'utilisateur attendu.");
    }
}
