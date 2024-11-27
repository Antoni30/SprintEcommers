package com.curso.ecommerce.sprintecommerce.Service;

import com.curso.ecommerce.sprintecommerce.model.Producto;
import com.curso.ecommerce.sprintecommerce.repository.ProductoRepository;
import com.curso.ecommerce.sprintecommerce.service.ProductoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testSave() {
        Producto producto = new Producto("Prueba","prueba", 250, 3);

        // Simula que el repositorio devuelve el mismo producto que se envía
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto result = productoService.save(producto);

        assertNotNull(result, "El producto no debería ser nulo");
        assertEquals("Prueba", result.getNombre(), "El nombre del producto no coincide");
        verify(productoRepository, times(1)).save(producto);
    }
}