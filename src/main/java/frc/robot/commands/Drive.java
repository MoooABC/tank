package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;

import java.util.function.Supplier;


public class Drive extends Command {

    private final Supplier<Double> rightSpeed;
    private final Supplier<Double> leftSpeed;
    private final Tank tank;

    public Drive(Tank tank, Supplier<Double> rightSpeed, Supplier<Double> leftSpeed) {
        addRequirements(tank);
        this.tank = tank;
        this.rightSpeed = rightSpeed;
        this.leftSpeed = leftSpeed;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        this.tank.setLeft(this.leftSpeed.get());
        this.tank.setRight(-this.rightSpeed.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.tank.stop();
    }
}
