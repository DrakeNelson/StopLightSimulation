/****************************************
 * Created by Drake Nelson on 4/11/2017.*
 * StopLight Simulation                 *
 ****************************************/
public class Main {
    public static void main(String[] args) {
        StopLight stopLight = new StopLight();
        stopLight.simulation();
        stopLight.printStats();
    }
}
/*
 * This Program is the take home section of test #2 on event based simulations.
 * Main: Driver running the StopLight
 * StopLight: the object that has the simulation method which executes the simulation
 * handles statistics for the stoplight, a clock that keeps track of time, 3 queues of cars for each of the 3 lanes of traffic (east/west, north/south - left turn and straight), a priorityqueue of events that orders them by the time they happen, has an enum variable that says who the light is green for, and a boolean to say whether left turns on the north/south road are legal.
 * StopLightEvent: abstract class StopLight holds a static list of with 3 different types of extension classes Arrival, Departure, StopLightChange all of which have access to the method to update stats, a time variable and belong to an interface that forces an execute method
 * Arrival: events that signal a new car being placed in the respective list, each one crates the next with poisson distro and if the queue of cars  is empty && stoplight is green then add a departure
 * Departure: removes cars from list and updates statistics
 * StopLightChange: changes what departure events may be executed and adds one to the queue
 * enums: has 4 enums i use throughout the program that are self explanatory
 * IStopLightEvent: just a little interface for the StopLightEvents to make sure they have an execute method
 */