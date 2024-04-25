package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// ProductServiceTest.java
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Success() {
        // Créer un mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Créer une instance de ProductService en lui passant le mock
        ProductService productService = new ProductService(productApiClientMock);

        // Définir le comportement attendu pour le mock
        String productId = "123";
        Product expectedProduct = new Product(/* Données de produit */);
        when(productApiClientMock.getProduct(productId)).thenReturn(expectedProduct);

        // Appeler la méthode à tester
        Product actualProduct = productService.getProduct(productId);

        // Vérifier que la méthode getProduct de ProductApiClient est appelée avec le bon argument
        verify(productApiClientMock).getProduct(productId);

        // Vérifier que le produit retourné par la méthode est celui attendu
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testGetProduct_Failure() {
        // Créer un mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Créer une instance de ProductService en lui passant le mock
        ProductService productService = new ProductService(productApiClientMock);

        // Définir le comportement attendu pour le mock
        String productId = "123";
        when(productApiClientMock.getProduct(productId)).thenThrow(new ApiException("API Call Failed"));

        // Appeler la méthode à tester et capturer l'exception
        ApiException exception = assertThrows(ApiException.class, () -> productService.getProduct(productId));

        // Vérifier que la méthode getProduct de ProductApiClient est appelée avec le bon argument
        verify(productApiClientMock).getProduct(productId);

        // Vérifier que l'exception est celle attendue
        assertEquals("API Call Failed", exception.getMessage());
    }
}
