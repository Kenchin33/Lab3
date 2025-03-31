package com.example.autobase.model;

public class Car {
    private String carId;
    private String type;
    private boolean workingCondition;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(boolean workingCondition) {
        this.workingCondition = workingCondition;
    }
}
