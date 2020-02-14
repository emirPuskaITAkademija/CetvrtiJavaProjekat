package advanced.konsultacije.car.entity;

import java.sql.Date;

public class Car {

    private final int id;
    private final String carName;
    private final String carType;
    private final String description;
    private final Date manufacturinDate;

    public Car(int id, String carName, String carType, String description, Date manufacturinDate) {
        this.id = id;
        this.carName = carName;
        this.carType = carType;
        this.description = description;
        this.manufacturinDate = manufacturinDate;
    }

    public int getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public String getDescription() {
        return description;
    }

    public Date getManufacturinDate() {
        return manufacturinDate;
    }

    @Override
    public String toString() {
        return carName + " : " + carType;
    }

}
