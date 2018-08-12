package org.abymaly.code.calculatorPriority;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPriority {

    public class PriorityPair {
        private double value;
        private int priority;

        public PriorityPair(double value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }

    public void calculator(String input) {

        String[] inputValues = input.split(" ");
        int currentPriorityValue = 0;

        List<PriorityPair> values = new ArrayList<>();
        for (String item : inputValues) {
            if ((!item.matches("[^0-9]"))) {
                values.add(new PriorityPair(Double.parseDouble(item), currentPriorityValue));
            }
        }

    }
}
