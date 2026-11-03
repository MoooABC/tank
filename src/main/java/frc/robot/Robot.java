// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.spikes2212.util.PlaystationControllerWrapper;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Tank;

import javax.swing.*;

public class Robot extends TimedRobot {
    private OI oi;
    private Drive drive;

    @Override
    public void robotInit() {
        this.oi = new OI(new PlaystationControllerWrapper(0));
        this.drive = new Drive(Tank.getInstance(), oi::getRY, oi::getLY);
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
        CommandScheduler.getInstance().schedule(drive);
    }

    @Override
    public void teleopPeriodic() {

    }

    /*@Override
    public void teleopExit() {
        CommandScheduler.getInstance().cancel(drive);
    }*/

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
