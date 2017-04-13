//stoplight events happen throughout the simulation in 3 types
public abstract class StopLightEvent implements IStopLightEvent{
    //every event must have a time it happens in
    int time;
    //get the time this event happens
    public int getTime() {
        return time;
    }
    //return the event type of any event
    public StopLightEventType getEventType() {
        return eventType;
    }
    StopLightEventType eventType;
}