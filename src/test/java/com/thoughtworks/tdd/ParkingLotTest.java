package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingLotTest {
    @Test
    public void should_parking_successfully_when_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        try {
            parkingLot.park(new Car());
        } catch (ParkingFullException e) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_fail_park_when_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);

        try {
            parkingLot.park(new Car());
            fail("should park successfully");
        } catch (ParkingFullException e) {

        }
    }

    @Test
    public void should_get_the_right_car_when_unpark_given_park_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car theCar = new Car();
        Receipt receipt = parkingLot.park(theCar);

        assertThat(parkingLot.unpark(receipt), is(theCar));
    }

    @Test
    public void should_get_the_wrong_car_when_unpark_given_park_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car theCar = new Car();
        Receipt receipt = null;
        Receipt anotherReceipt = null;
        try {
            receipt = parkingLot.park(theCar);
        } catch (Exception e) {
            fail("should park successfully");
        }

        assertThat(parkingLot.unpark(anotherReceipt), not(theCar));
    }

    @Test
    public void should_be_true_when_call_isFull_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);

        assertThat(parkingLot.isFull(), is(true));
    }

    @Test
    public void should_be_false_when_call_isFull_given_parking_lot_is_not_full() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertThat(parkingLot.isFull(), is(false));
    }

    @Test
    public void should_be_false_when_call_isFull_given_full_parking_lot_take_out_of_a_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        parkingLot.unpark(receipt);
        assertThat(parkingLot.isFull(), is(false));
    }

    @Test
    public void should_be_true_when_call_park_again_given_full_parking_lot_take_out_of_a_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        parkingLot.unpark(receipt);

        try {
            parkingLot.park(new Car());
        } catch (ParkingFullException e) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_successfully_when_call_park_given_parking_lots_is_not_full() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(1)});
        Car car = new Car();

        try {
            Receipt receipt = parkingLots.park(car);
        } catch (ParkingFullException e) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_unsuccessfully_when_call_park_given_parking_lots_is_full() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(0)});
        Car car = new Car();

        try {
            Receipt receipt = parkingLots.park(car);
            fail("should park unsuccessfully");
        } catch (ParkingFullException e) {

        }
    }

    @Test
    public void should_get_the_right_car_when_call_unpark_given_receipt_of_the_car() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(1)});
        Car car = new Car();

        Receipt receipt = parkingLots.park(car);
        assertThat(parkingLots.unpark(receipt), is(car));
    }

    @Test
    public void should_get_the_wrong_car_when_call_unpark_given_another_receipt() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(1)});
        Car car = new Car();
        Receipt receipt = parkingLots.park(car);
        Receipt anotherReceipt = new Receipt();

        assertThat(parkingLots.unpark(anotherReceipt), not(car));
    }

    @Test
    public void should_park_successfully_when_call_park_again_given_full_parking_lot_take_out_a_car() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(1)});
        Car car = new Car();
        Receipt receipt = parkingLots.park(car);
        parkingLots.unpark(receipt);

        try {
            parkingLots.park(new Car());
        } catch (ParkingFullException e) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_unsuccessfully_when_call_park_again_given_wrong_receipt_for_full_parking_lot() {
        ParkingBoy parkingLots = new ParkingBoy(new ParkingLot[] {new ParkingLot(0), new ParkingLot(1)});
        Car car = new Car();
        Receipt receipt = parkingLots.park(car);
        parkingLots.unpark(new Receipt());

        try {
            parkingLots.park(new Car());
            fail("should park successfully");
        } catch (ParkingFullException e) {

        }
    }

    @Test
    public void should_park_successfully_when_call_park_given_two_car() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[] {new ParkingLot(1), new ParkingLot(1)});

        try {
            parkingBoy.park(new Car());
            parkingBoy.park(new Car());
        } catch (ParkingFullException e) {
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_sequentially_when_call_park_given_two_car() {
        ParkingLot p1 = new ParkingLot(1);
        ParkingLot p2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot[] {p1, p2});
        Car c1 = new Car();
        Car c2 = new Car();
        Receipt r1 = parkingBoy.park(c1);
        Receipt r2 = parkingBoy.park(c2);

        assertThat(c1 == p1.unpark(r1) && c2 == p2.unpark(r2), is(true));
    }
}
