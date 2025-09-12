package com.taller2;

// Clase que no permite que la hereden otras clases
public final class Recursion {

    // Atributo estático privado no modificable. Evita implementar tantas recursiones
    private static final int factorial_max = 10;

    // Para evitar instanciar la clase. La clase funciona mas como un módulo de funciones
    private Recursion() {}

    // Método recursivo para sumar, solo acepta enteros positivos
    public static int suma(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("El método solo acepta enteros positivos.");
        }
        if (b == 0) return a;
        return suma(a + 1, b - 1);
    }
    /*
    Método recursivo para multiplicar, que a su vez llama otro método recursivo (suma)
    Solo acepta enteros positivos
     */
    public static int multiplicar(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("El método solo acepta enteros positivos.");
        }
        // Recurrente sobre el menor para reducir profundidad de la recursión
        if (a > b) { int t = a; a = b; b = t; }
        if (a == 0) return 0;
        return suma(b, multiplicar(a - 1, b));
    }

    /*
    Método recursivo para calculcar un factorial, que a su vez llama otros dos métodos
    recursivos (suma y multiplicar). Solo acepta enteros positivos
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial está definido para n >= 0.");
        }
        if (n > factorial_max) {
            throw new IllegalArgumentException(
                    "Factorial máximo permitido es " + factorial_max + " (10! cabe en int)."
            );
        }
        if (n <= 1) return 1;
        return multiplicar(n, factorial(n - 1));
    }
}
