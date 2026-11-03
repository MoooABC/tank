package frc.robot;

import com.spikes2212.util.PlaystationControllerWrapper;

public class OI {

    private final PlaystationControllerWrapper controller;

    public OI(PlaystationControllerWrapper controller) {
        this.controller = controller;
    }

    public double getRY() {
        return controller.getRightY() * 0.3;
    }

    public double getLY() {
        return controller.getLeftY() * 0.3;
    }
}
