//  1. Stoplight Change Event   //
public class StopLightChangeEvent extends StopLightEvent {
    public StopLightChangeEvent(int time) {
        this.time = time;
        eventType=StopLightEventType.STOPLIGHT_CHANGE;
    }

    @Override
    public void execute() {

    }
}