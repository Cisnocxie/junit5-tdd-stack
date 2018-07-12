package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot[] parkingLots;

    public ParkingBoy(ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        for (int i = 0; i < parkingLots.length; i++) {
            if (!parkingLots[i].isFull()) {
                return parkingLots[i].park(car);
            }
        }
        throw new ParkingFullException();
    }

    public Car unpark(Receipt receipt) {
        Car car = null;
        for (ParkingLot p : parkingLots) {
            car = p.unpark(receipt);
            if (car != null) break;
        }
        return car;
    }
}
