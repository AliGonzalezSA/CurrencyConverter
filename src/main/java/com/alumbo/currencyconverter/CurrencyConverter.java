package com.alumbo.currencyconverter;

import com.google.gson.JsonObject;

public class CurrencyConverter {

    // Método para convertir una cantidad de dinero usando la tasa de cambio
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) throws Exception {
        // Obtener las tasas de cambio
        JsonObject exchangeRates = CurrencyAPI.getExchangeRates();

        // Verificar si la respuesta contiene tasas
        if (exchangeRates != null && exchangeRates.has("rates")) {
            JsonObject rates = exchangeRates.getAsJsonObject("rates");

            // Verificar si las monedas de origen y destino están presentes en las tasas
            if (rates.has(fromCurrency) && rates.has(toCurrency)) {
                double fromRate = rates.get(fromCurrency).getAsDouble();
                double toRate = rates.get(toCurrency).getAsDouble();

                // Realizar la conversión
                return (amount / fromRate) * toRate;
            } else {
                throw new Exception("Las monedas no se encuentran en las tasas de cambio.");
            }
        } else {
            throw new Exception("No se pudieron obtener las tasas de cambio.");
        }
    }
}