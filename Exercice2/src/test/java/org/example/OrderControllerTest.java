package org.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

// OrderControllerTest.java
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Créer un mock pour OrderService
        OrderService orderServiceMock = mock(OrderService.class);

        // Créer un mock pour OrderDao
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Créer une instance de OrderController en lui passant les mocks
        OrderController orderController = new OrderController(orderServiceMock);

        // Définir le comportement attendu pour les mocks
        Order order = new Order(1, "John Doe", 100.0);

        // Appeler la méthode à tester
        orderController.createOrder(order);

        // Vérifier que la méthode createOrder de OrderService est appelée avec le bon argument
        verify(orderServiceMock).createOrder(order);

        // Vérifier que la méthode saveOrder de OrderDao est appelée avec l'objet de commande créé
        verify(orderDaoMock).saveOrder(order);
    }
}
