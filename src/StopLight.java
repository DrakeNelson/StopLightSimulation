import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by user on 4/12/2017.
 */
public class StopLight {
    //Stoplight has a clock to keep track of runtime in seconds
    private int clock;
    //end time for the simulation
    private int endTimeClock;
    private Stats stats;
    //Queue for the cars on the eastwest road
    Queue<Car> eastCars,northCars,westCars;

    //constructor for the stoplight
    public StopLight(){
        endTimeClock=100*60*60;
        eastCars=new LinkedList<>();
        northCars=new LinkedList<>();
        westCars=new LinkedList<>();
        stats = new Stats();
    }

    //main driver for the simulation
    public void simulation(){
        //the simulation loop
        while (clock < endTimeClock) {

        }
    }

    public void printStats() {
        stats.print();
    }

    //The car objects arrive at the stoplight
    // on 1 of two roads,
    // with an intent to Turn left right or straight,
    // arrive and depart at a specific time
    private class Car{
        private Road road;
        private Turn turnIntent;
        private int arrivalTime,departureTime;

        //constructor for the car
        private Car(Road road){
            this.road=road;

        }
    }
    private enum Road{EASTWEST, NORTHSOUTH}
    private enum Turn{LEFT,RIGHT,STRAIGHT}

    //another inner class holds the statistics
    private class Stats{
        //constructor for the statistics
        private Stats(){

        }
        //prints the statistics
        private void print() {
            System.out.print("x");
        }
    }
}
