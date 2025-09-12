package com.taller2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class RecursionTest {

    // Probando suma()

    @ParameterizedTest(name = "suma({0}, {1}) = {2}")
    @CsvSource({
            "0, 0, 0",
            "5, 0, 5",
            "0, 7, 7",
            "3, 4, 7",
            "10, 10, 20"
    })
    void suma_ok(int a, int b, int esperado) {
        assertEquals(esperado, Recursion.suma(a, b));
    }

    @ParameterizedTest(name = "suma({0}, {1}) debe lanzar error")
    @CsvSource({
            "-1, 0",
            "0, -1",
            "-3, 5",
            "5, -8"
    })
    void suma_negativos(int a, int b) {
        assertThrows(IllegalArgumentException.class, () -> Recursion.suma(a, b));
    }

    // Probando multiplicar()

    @ParameterizedTest(name = "multiplicar({0}, {1}) = {2}")
    @CsvSource({
            "0, 0, 0",
            "0, 5, 0",
            "5, 0, 0",
            "1, 7, 7",
            "7, 1, 7",
            "3, 4, 12",
            "7, 2, 14",
            "9, 1, 9"
    })
    void multiplicar_ok(int a, int b, int esperado) {
        assertEquals(esperado, Recursion.multiplicar(a, b));
    }

    @ParameterizedTest(name = "conmutatividad: {0}*{1} == {1}*{0}")
    @CsvSource({
            "3, 5",
            "2, 9",
            "10, 4",
            "6, 6"
    })
    void multiplicar_conmutativa(int a, int b) {
        assertEquals(Recursion.multiplicar(a, b), Recursion.multiplicar(b, a));
    }

    // Probando factorial()

    @ParameterizedTest(name = "factorial({0}) = {1}")
    @MethodSource("factorialCases")
    void factorial_ok(int n, int esperado) {
        assertEquals(esperado, Recursion.factorial(n));
    }

    static Stream<Arguments> factorialCases() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720),
                Arguments.of(7, 5040),
                Arguments.of(8, 40320),
                Arguments.of(9, 362880),
                Arguments.of(10, 3628800)
        );
    }

    @Test
    void factorial_negativo_lanza() {
        assertThrows(IllegalArgumentException.class, () -> Recursion.factorial(-1));
    }

    @ParameterizedTest(name = "factorial({0}) > 10! debe lanzar IAE")
    @CsvSource({ "11", "12", "20" })
    void factorial_limite(int n) {
        assertThrows(IllegalArgumentException.class, () -> Recursion.factorial(n));
    }
}
