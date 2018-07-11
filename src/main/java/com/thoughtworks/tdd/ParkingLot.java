package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int size;
    private Map<Receipt, Car> carList;

    public ParkingLot(int size) {
        this.size = size;
        carList = new HashMap<Receipt, Car>();
    }

    public Receipt park(Car car) {
        if (carList.size() == size) {
            throw new ParkingFullException();
        }
        Receipt receipt = new Receipt();
        carList.put(receipt, car);
        return receipt;
    }

    public Car unpark(Receipt receipt) {
        return carList.remove(receipt);
    }

    public boolean isFull() {
        return carList.size() == size;
    }
}
