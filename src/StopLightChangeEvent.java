//  1. Stoplight Change Event   //
public class StopLightChangeEvent extends StopLightEvent {
    StopLightStatus status;

    public StopLightChangeEvent(int time, StopLightStatus status) {
        this.time = time;
        this.status = status;
        eventType = StopLightEventType.STOPLIGHT_CHANGE;
    }

    @Override
    public void execute() {
        switch (status) {
            case EAST_GREEN:
                StopLight.stopLightStatus = StopLightStatus.EAST_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time +120, StopLightStatus.WEST_GREEN));
                break;
            case NORTH_GREEN:
                StopLight.stopLightStatus = StopLightStatus.NORTH_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time + 150, StopLightStatus.EAST_GREEN));
                break;
            case WEST_GREEN:
                StopLight.stopLightStatus = StopLightStatus.WEST_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time + 30, StopLightStatus.NORTH_GREEN));
                break;
            default:
                break;

        }
        StopLight.addEvent(new DepartureEvent(time));
    }
}