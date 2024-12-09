package com.alumbo.currencyconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al Conversor de Divisas!");

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar la cantidad a convertir
        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Solicitar la moneda de origen
        System.out.print("Ingrese la moneda de origen (por ejemplo, USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        // Solicitar la moneda de destino
        System.out.print("Ingrese la moneda de destino (por ejemplo, USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            // Realizar la conversión
            double convertedAmount = CurrencyConverter.convertCurrency(amount, fromCurrency, toCurrency);

            // Mostrar el resultado
            System.out.printf("La cantidad %.2f %s es %.2f %s.\n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            // Manejar cualquier error
            System.out.println("Error: " + e.getMessage());
        }

        // Cerrar el scanner
        scanner.close();
    }
}