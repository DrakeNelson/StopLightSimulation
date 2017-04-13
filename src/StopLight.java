/*
  Created by Drake Nelson on 4/12/2017.
  The stoplight simulation stoplight object is the object being simulated
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class StopLight {
    //Stoplight has a clock to keep track of runtime in seconds
    private static int clock;

    public static int getClock() {
        return clock;
    }

    //end time for the simulation
    private int endTimeClock;
    private Stats stats;
    //Queue for the cars on the eastwest road
    private static Queue<Car> eastCars, northCars, westCars;

    static void addCar(Car car) {
        if (car.getRoad() == Road.EASTWEST) {
            eastCars.add(car);
        } else if (car.getPath() == Path.NORTH_NORTH) {
            northCars.add(car);
        } else {
            westCars.add(car);
        }
    }

    //PriorityQueue:stopLightEvents is a queue that holds the events in the order they will happen based on the clock time
    private static PriorityQueue<StopLightEvent> stopLightEvents = new PriorityQueue<>(10, new StopLightEventComparator());

    static void addEvent(StopLightEvent e) {
        stopLightEvents.add(e);
    }

    //constructor for the stoplight
    StopLight() {
        //1000 hours * 60 minutes * 60 seconds runs the simulation for total time in seconds
        endTimeClock = 1000 * 60 * 60;
        eastCars = new LinkedList<>();
        northCars = new LinkedList<>();
        westCars = new LinkedList<>();
        stats = new Stats();
        clock = 0;
    }

    void simulation() {
        stopLightEvents.add(new ArrivalEvent(0, Road.EASTWEST));
        stopLightEvents.add(new ArrivalEvent(0, Road.NORTHSOUTH));
        while (clock < endTimeClock) {
            StopLightEvent event = stopLightEvents.poll();
            event.execute();
        }
        stats.setAverages();
    }

    void printStats() {
        stats.print();
    }


    //another inner class holds the statistics
    private class Stats {
        //todo constructor for the statistics
        private Stats() {

        }

        //todo this
        private void print() {
            System.out.print("x");
        }

        //todo this
        public void setAverages() {

        }
    }
}
