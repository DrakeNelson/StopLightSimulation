//  3. Departure Event            //
public class DepartureEvent extends StopLightEvent {

    private Path path;
    private Road road;

     DepartureEvent(int time) {
        this.time = time;
        eventType = StopLightEventType.DEPARTURE;
    }

     DepartureEvent(int time, Road road) {
        this.time = time;
        eventType = StopLightEventType.DEPARTURE;
        this.road = road;
    }

     DepartureEvent(int time, Road road, Path path) {
        this.time = time;
        eventType = StopLightEventType.DEPARTURE;
        this.road = road;
        this.path = path;
    }
    private void removeCar(Car car, Path path){
        if (car != null) {
            car.setDepartureTime(time);
            car.isClear = true;
            StopLight.totalNSCars++;
            StopLight.totalNSWaitTime+=car.getDepartureTime()-car.getArrivalTime();
            StopLight.addEvent(new DepartureEvent(time + car.getClearTime(), Road.NORTH_SOUTH, path));
        }
    }
    @Override
    public void execute() {
        Car car;
        //execute the departure if the light on the east/west road is green
        if (road == Road.EAST_WEST) {
            if (StopLight.stopLightStatus == StopLightStatus.EAST_GREEN) {
                car = StopLight.getEastCars().poll();
                if (car != null) {
                    car.setDepartureTime(time);
                    car.isClear = true;
                    StopLight.totalEWCars++;
                    StopLight.totalEWWaitTime+=car.getDepartureTime()-car.getArrivalTime();
                    StopLight.addEvent(new DepartureEvent(time + car.getClearTime(), Road.EAST_WEST));
                }
            }
        } else if (road == Road.NORTH_SOUTH) {
            //if the event is on the north/south road
            //check WHAT THE PATH OF THE EVENT IS
            if (path == Path.NORTH_WEST) {
                //if the path of the event is west
                if (StopLight.stopLightStatus == StopLightStatus.WEST_GREEN) {
                    //if the stoplight is green arrow
                    //poll the car queue and depart it, add another depart for this path when its done
                    car = StopLight.getWestCars().poll();
                    removeCar(car, Path.NORTH_WEST);
                } else if (StopLight.stopLightStatus == StopLightStatus.NORTH_GREEN) {
                    //if the stoplight is circle roll the dice
                    StopLight.canMakeLeftTurn = (int) (Math.random() * 10) > 4;
                    if (StopLight.canMakeLeftTurn) {
                        //if dice roll is good then depart and add another event for the path
                        car = StopLight.getWestCars().poll();
                        removeCar(car, Path.NORTH_WEST);
                    }
                }
            } else {
                //if the path of the event is north
                if (StopLight.stopLightStatus == StopLightStatus.EAST_GREEN || StopLight.stopLightStatus == StopLightStatus.NORTH_GREEN) {
                    //if stoplight is green arrow or circle
                    car = StopLight.getNorthCars().poll();
                    removeCar(car, Path.NORTH_NORTH);
                }

            }
        }
    }
}