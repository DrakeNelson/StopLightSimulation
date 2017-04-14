//stoplight events happen throughout the simulation in 3 types
 abstract class StopLightEvent implements IStopLightEvent{
    //every event must have a time it happens in
    int time;
    //return the event type of any event
    //StopLightEventType eventType;

    void updateAverageInLine(Road road){
        if (road == Road.EAST_WEST) {
            double deltaTime = (double)time - StopLight.lastEWEventTime;
            double lineLength = StopLight.getEastCars().size();
            StopLight.lastEWEventTime=time;
            StopLight.deltaTimeSumEW+=deltaTime*lineLength;
        } else {
            double deltaTime = (double) time - StopLight.lastNSEventTime;
            double lineLength = StopLight.getEastCars().size()+StopLight.getNorthCars().size();
            StopLight.lastNSEventTime=time;
            StopLight.deltaTimeSumNS+=deltaTime*lineLength;
        }
    }
}