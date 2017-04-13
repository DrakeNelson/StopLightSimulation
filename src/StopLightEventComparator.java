import java.util.Comparator;

//comparator:events will be added to the queue based on the time they are to happen
public class StopLightEventComparator implements Comparator<StopLightEvent> {
    @Override
    public int compare(StopLightEvent x, StopLightEvent y) {
        if (x.time > y.time) {
            return -1;
        } else {
            return 1;
        }
    }
}