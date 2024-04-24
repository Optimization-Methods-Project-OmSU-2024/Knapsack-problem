package org.knapsack_problem.omsu.data_types;

import java.util.Objects;

public class ValueAndQuantity {
    private double value;
    private int quantity;

    public ValueAndQuantity(double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueAndQuantity that = (ValueAndQuantity) o;
        return Double.compare(value, that.value) == 0 && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, quantity);
    }

    @Override
    public String toString() {
        return "ValueAndQuantity{" +
                "value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
