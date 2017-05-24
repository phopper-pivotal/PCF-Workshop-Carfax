package io.pivotal.usedvehicle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String listDate;
    private String manufacturedYear;
    private String make;
    private String model;
    private long price;
    private long mileage;
    private String location;
    private String exteriorColor;
    private String interiorColor;
    private String driveType;
    private String transmission;
    private String bodyStyle;
    private String engine;
    private String fuel;
    private String vin;
    private String stockNumber;
    private int mpgCity;
    private int mpgHighway;
    private String features;
    private String description;

    public Vehicle() {}

    public Vehicle(String listDate, String manufacturedYear, String make, String model, long price, long mileage, String location, String exteriorColor,
                   String interiorColor, String driveType, String transmission, String bodyStyle,
                   String engine, String fuel, String vin, String stockNumber, int mpgCity, int mpgHighway,
                   String features, String description) {
        this.listDate = listDate;
        this.manufacturedYear = manufacturedYear;
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
        this.location = location;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.driveType = driveType;
        this.transmission = transmission;
        this.bodyStyle = bodyStyle;
        this.engine = engine;
        this.fuel = fuel;
        this.vin = vin;
        this.stockNumber = stockNumber;
        this.mpgCity = mpgCity;
        this.mpgHighway = mpgHighway;
        this.features = features;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getListDate() {
        return listDate;
    }

    public void setListDate(String listDate) {
        this.listDate = listDate;
    }

    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getMpgCity() {
        return mpgCity;
    }

    public void setMpgCityCity(int mgpCity) {
        this.mpgCity = mpgCity;
    }

    public int getMpgHighway() {
        return mpgHighway;
    }

    public void setMpgHighway(int mpgHighway) {
        this.mpgHighway = mpgHighway;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", listDate='" + listDate + '\'' +
                ", manufacturedYear='" + manufacturedYear + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + '\'' +
                ", mileage=" + mileage + '\'' +
                ", location='" + location + '\'' +
                ", exteriorColor='" + exteriorColor + '\'' +
                ", interiorColor='" + interiorColor + '\'' +
                ", driveType='" + driveType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", engine='" + engine + '\'' +
                ", fuel='" + fuel + '\'' +
                ", vin='" + vin + '\'' +
                ", stockNumber='" + stockNumber + '\'' +
                ", mgpCity=" + mpgCity +
                ", mpgHighway=" + mpgHighway +
                ", features='" + features + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
