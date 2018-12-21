
import org.lgna.story.resources.prop.PocketWatchResource;
import org.lgna.story.*;

public class PocketWatch extends Prop {

    public PocketWatch() {
        super(PocketWatchResource.DEFAULT);
    }

    public SJoint getHour() {
        return this.getJoint(PocketWatchResource.HOUR);
    }

    public SJoint getMinute() {
        return this.getJoint(PocketWatchResource.MINUTE);
    }
}
