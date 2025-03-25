package com.example.projectbus.model;

public class Bus {
    private int id;
    private String licensePlate;
    private String vehicleType;
    private int seatNumber;
    private String vehicleStatus;
    private String lastMaintenance;
    private boolean isDelete;
    private String urlImg;

    public Bus() {
    }

    public Bus(int id, String licensePlate, String vehicleType, int seatNumber, String vehicleStatus, String lastMaintenance, boolean isDelete, String urlImg) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.seatNumber = seatNumber;
        this.vehicleStatus = vehicleStatus;
        this.lastMaintenance = lastMaintenance;
        this.isDelete = isDelete;
        this.urlImg = urlImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(String lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
