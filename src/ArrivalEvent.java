//  2. Arrival Event          //
public class ArrivalEvent extends StopLightEvent {
    private Road road;

    public ArrivalEvent(int time, Road road) {
        this.time = time;
        this.road = road;
        eventType = StopLightEventType.ARRIVAL;

    }

    @Override
    public void execute() {
        if (road == Road.EASTWEST) {
            int nextArrivalTime = StopLight.getClock()+(int) (900 * Math.log(1 - Math.random()) / -30.0);
            Car car = new Car(road, nextArrivalTime);
            StopLight.addCar(car);
            StopLight.addEvent(new ArrivalEvent(nextArrivalTime, Road.EASTWEST));
        } else {
            int nextArrivalTime = StopLight.getClock()+(int) (900 * Math.log(1 - Math.random()) / -45.0);
            Car car = new Car(road, nextArrivalTime);
            StopLight.addCar(car);
            StopLight.addEvent(new ArrivalEvent(nextArrivalTime,Road.NORTHSOUTH));
        }
    }
}