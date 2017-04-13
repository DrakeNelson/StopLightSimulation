//  2. Arrival Event          //
//event spawns next arrival event for a new car & also a departureevent if the queu
public class ArrivalEvent extends StopLightEvent {
    private Road road;

    ArrivalEvent(int time, Road road) {
        this.time = time;
        this.road = road;
        eventType = StopLightEventType.ARRIVAL;
    }

    @Override
    public void execute() {
        //check the road if its on the east road
        if (road == Road.EAST_WEST) {
            //set the next arrival time
            int nextArrivalTime = StopLight.getClock() + (int) (900 * Math.log(1 - Math.random()) / -30.0);
            //add an arrival event
            StopLight.addEvent(new ArrivalEvent(nextArrivalTime, Road.EAST_WEST));
            //create a car that arrives at the next arrival on the specified road
            Car car = new Car(road, nextArrivalTime);
            //add that car to the respective queue
            StopLight.addCar(car);
            //check if this car is the first thing in the queue
            if (StopLight.getEastCars().peek() == car && StopLight.stopLightStatus == StopLightStatus.EAST_GREEN) {
                StopLight.addEvent(new DepartureEvent(time,Road.EAST_WEST));
            }
            //System.out.println("car arrived on the east/west road turning "+car.getPath());
        } else { //or if the car comes from the north
            int nextArrivalTime = StopLight.getClock() + (int) (900 * Math.log(1 - Math.random()) / -45.0);
            Car car = new Car(road, nextArrivalTime);
            StopLight.addCar(car);
            StopLight.addEvent(new ArrivalEvent(nextArrivalTime, Road.NORTH_SOUTH));
            if(car.getPath()==Path.NORTH_WEST){
                if (StopLight.getWestCars().peek() == car && StopLight.stopLightStatus == StopLightStatus.WEST_GREEN) {
                    StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_WEST));
                }
            }else if(car.getPath()==Path.NORTH_NORTH){
                if (StopLight.getNorthCars().peek() == car && StopLight.stopLightStatus == StopLightStatus.NORTH_GREEN) {
                    StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_NORTH));
                }
            }
            //System.out.println("car arrived on the north/south road turning" + car.getPath());
        }
        StopLight.setClock(time);
    }
}