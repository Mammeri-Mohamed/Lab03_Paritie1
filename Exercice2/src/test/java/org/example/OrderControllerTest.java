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
        OrderDao orderDaoMock = mock(OrderDao.class);
        OrderService orderService=new OrderService(orderDaoMock);

        // Créer un mock pour OrderDao

        Order order = new Order(1, "John Doe", 100.0);


        doAnswer(invocation -> {
            // Faire quelque chose ici si nécessaire
            return null; // La méthode est de type void, donc retourner null
        }).when(orderDaoMock).saveOrder(order);

        // Créer une instance de OrderController en lui passant les mocks
        OrderController orderController = new OrderController(orderService);

        // Définir le comportement attendu pour les mocks

        // Appeler la méthode à tester
        orderController.createOrder(order);

        // Vérifier que la méthode createOrder de OrderService est appelée avec le bon argument

        // Vérifier que la méthode saveOrder de OrderDao est appelée avec l'objet de commande créé
        verify(orderDaoMock).saveOrder(order);
    }
}
