//  1. Stoplight Change Event   //
public class StopLightChangeEvent extends StopLightEvent {
    private StopLightStatus status;

    StopLightChangeEvent(int time, StopLightStatus status) {
        this.time = time;
        this.status = status;
        //eventType = StopLightEventType.STOPLIGHT_CHANGE;
    }

    @Override
    public void execute() {
        switch (status) {
            case EAST_GREEN:
                StopLight.stopLightStatus = StopLightStatus.EAST_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time +120, StopLightStatus.WEST_GREEN));
                StopLight.addEvent(new DepartureEvent(time,Road.EAST_WEST));
                StopLight.canMakeLeftTurn=false;
                break;
            case NORTH_GREEN:
                StopLight.stopLightStatus = StopLightStatus.NORTH_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time + 150, StopLightStatus.EAST_GREEN));
                StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_NORTH));
                StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_WEST));
                //StopLight.canMakeLeftTurn=(int)(Math.random()*10)>4;
                break;
            case WEST_GREEN:
                StopLight.stopLightStatus = StopLightStatus.WEST_GREEN;
                StopLight.addEvent(new StopLightChangeEvent(time + 30, StopLightStatus.NORTH_GREEN));
                StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_WEST));
                StopLight.addEvent(new DepartureEvent(time,Road.NORTH_SOUTH,Path.NORTH_NORTH));
                StopLight.canMakeLeftTurn=true;
                break;
            default:
                break;

        }
    }
}