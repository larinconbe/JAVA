package com.devsenior;

// Clase de pruebas unitarias que utiliza JUnit 5 para verificar 
// que los métodos de la clase Calculadora funcionan correctamente.

// Importaciones
// Import static permite usar lo metodos directamente
// AssertEquals sirve para comparar 2 valores
// AssertThrows sirve para verificar que un metodo lance una excepcion
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
// Permite marcar métodos como pruebas unitarias.
import org.junit.jupiter.api.Test;

// Declaracion de la clase 
public class CalculadoraTest {

    // Prueba de suma - @Test indica que se va a crear un metodo de prueba
    // Los metodos de Test no deben ser privados ni estaticos y no deben devolver
    // ningun valor
    @Test
    void testSuma() {
        // Se crea la calculadora: calc
        Calculadora calc = new Calculadora();
        // Compara el valor establecido 5 con la suma de 2 + 3, si el resultado es 5 la
        // prueba pasa
        assertEquals(5, calc.sumar(2, 3));
    }

    @Test
    void testResta() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.restar(10, 5));
    }

    @Test
    void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(25, calc.multiplicar(5, 5));
    }

    @Test
    void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.dividir(12, 2));
    }

    // Prueba de division por cero
    // Esta prueba verifica que la calculadora maneje correctamente un error.
    @Test
    void testDivisionPorCero() {
        // Crear la calculadora
        Calculadora calc = new Calculadora();
        // Capturar la excepcion, se valida que calc.dividir lance
        // IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.dividir(6, 0);
        });
        // Compara valor esperado con valor obtenido
        assertEquals("No es posible dividir por cero", exception.getMessage());
    }
}
