package com.learning.treesandgraphs.dijkstra;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.HashMap;
import java.util.Map;

/*
Doesn't work with @TestFactory
Works with @Test
 */

public class CitiesParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == Map.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        Map<String, Integer> cities = null;
        if (parameterContext.getParameter().getType() == Map.class) {
            cities = CitiesParameterResolver.getCities();
        }
          return cities;
    }

    public static Map<String, Integer> getCities() {
        Map<String, Integer> cities = new HashMap<>();
        cities.put("karakow", 0);
        cities.put("brzesko", 26);
        cities.put("wawrzenczyce", 10);
        cities.put("wieliczka", 5);
        cities.put("bochnia", 25);
        return cities;
    }
}
