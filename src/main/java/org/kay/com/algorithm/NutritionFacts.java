package org.kay.com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NutritionFacts {

    private List<String> parameters;

    public List<String> getParameters() {
        return parameters;
    }

    public static class Builder {
        private List<String> parameters = new ArrayList<>();

        public Builder parameter(String str) {
            parameters.add(str);
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder buider) {
        this.parameters = buider.parameters;
    }

    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts.Builder()
                                                 .parameter("23")
                                                 .parameter("123")
                                                 .build();
        System.out.println(facts.getParameters());
    }
}
