//  3. Departure Event            //
public class DepartureEvent extends StopLightEvent{
    public DepartureEvent(int time) {
        this.time = time;
        eventType=StopLightEventType.DEPARTURE;
    }

    @Override
    public void execute() {

    }
}