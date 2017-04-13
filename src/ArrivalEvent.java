//  2. Arrival Event          //
public class ArrivalEvent extends StopLightEvent{
    private Road road;

    public ArrivalEvent(int time, Road road) {
        this.time = time;
        this.road = road;
        eventType=StopLightEventType.ARRIVAL;
    }

    @Override
    public void execute() {

    }
}