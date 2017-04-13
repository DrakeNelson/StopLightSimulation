//stoplight events happen throughout the simulation in 3 types
 abstract class StopLightEvent implements IStopLightEvent{
    //every event must have a time it happens in
    int time;
    //return the event type of any event
    StopLightEventType eventType;
}