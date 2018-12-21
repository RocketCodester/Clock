/*
   9/16/14
   JDK 1.7
   Make the hour hand on a clock move based on user input
*/
import javax.swing.JOptionPane;
import org.lgna.story.event.SceneActivationListener;
import org.lgna.story.event.SceneActivationEvent;
import org.lgna.story.*;

public class Scene extends SScene {

    public Scene() {
        super();
    }

    private void performCustomSetup() {
    }

    private void performGeneratedSetUp() {
        this.setAtmosphereColor(new Color(0.588, 0.886, 0.988));
        this.setFromAboveLightColor(Color.WHITE);
        this.setFromBelowLightColor(Color.BLACK);
        this.setFogDensity(0.0);
        this.setName("myScene");
        this.camera.setName("camera");
        this.camera.setVehicle(this);
        this.camera.setOrientationRelativeToVehicle(new Orientation(0.0, 0.995185, 0.0980144, 6.12323E-17));
        this.camera.setPositionRelativeToVehicle(new Position(9.61E-16, 1.56, -7.85));
        this.clock.setPaint(Color.WHITE);
        this.clock.setOpacity(1.0);
        this.clock.setName("clock");
        this.clock.setVehicle(this);
        this.clock.setOrientationRelativeToVehicle(new Orientation(0.0, 0.0, 0.0, 1.0));
        this.clock.setPositionRelativeToVehicle(new Position(-0.079, 0.0, 0.61));
        this.clock.setSize(new Size(1.82, 2.54, 0.52));
    }

    private void initializeEventListeners() {
        this.addSceneActivationListener(new SceneActivationListener() {
            @Override
            public void sceneActivated(final SceneActivationEvent e) {
                Scene.this.myFirstMethod();
            }
        });
    }

    @Override
    protected void handleActiveChanged(final Boolean isActive, final Integer activationCount) {
        if (isActive) {
            if (activationCount == 1) {
                this.performGeneratedSetUp();
                this.performCustomSetup();
                this.initializeEventListeners();
            } else {
                this.restoreStateAndEventListeners();
            }
        } else {
            this.preserveStateAndEventListeners();
        }
    }

    public void myFirstMethod() {
        String input = JOptionPane.showInputDialog(null, "Enter hour of the day");
        int hour = Integer.parseInt(input);
        double time = hour/12.0;
        this.clock.getHour().roll(RollDirection.LEFT, time);
        input = JOptionPane.showInputDialog(null, "Enter minute of the day");
        int minute = Integer.parseInt(input);
        time = minute/60.0;
        this.clock.getMinute().roll(RollDirection.LEFT, time);
    }

    public SCamera getCamera() {
        return this.camera;
    }

    public PocketWatch getClock() {
        return this.clock;
    }
    private final SCamera camera = new SCamera();
    private final PocketWatch clock = new PocketWatch();
}         