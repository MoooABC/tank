package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.spikes2212.util.smartmotorcontrollers.SparkWrapper;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Tank extends SubsystemBase {
    private SparkWrapper leftMotorMaster;
    private SparkWrapper rightMotorMaster;
    private static Tank instance;

    private Tank(
            SparkWrapper leftMotorMaster, SparkWrapper leftMotorSlave,
            SparkWrapper rightMotorMaster, SparkWrapper rightMotorSlave
    ) {
        this.leftMotorMaster = leftMotorMaster;
        this.rightMotorMaster = rightMotorMaster;

        rightMotorSlave.follow(rightMotorMaster);
        leftMotorSlave.follow(leftMotorMaster);
    }

    public static Tank getInstance() {
        if (Tank.instance == null) {
            Tank.instance = new Tank(
                    SparkWrapper.createSparkMax(
                            RobotMap.CAN.LEFT_MOTOR_MASTER_ID,
                            SparkLowLevel.MotorType.kBrushless
                    ),
                    SparkWrapper.createSparkMax(
                            RobotMap.CAN.LEFT_MOTOR_SLAVE_ID,
                            SparkLowLevel.MotorType.kBrushless
                    ),
                    SparkWrapper.createSparkMax(
                            RobotMap.CAN.RIGHT_MOTOR_MASTER_ID,
                            SparkLowLevel.MotorType.kBrushless
                    ),
                    SparkWrapper.createSparkMax(
                            RobotMap.CAN.RIGHT_MOTOR_SLAVE_ID,
                            SparkLowLevel.MotorType.kBrushless
                    )
            );
        }
        return Tank.instance;
    }

    public void setLeft(double speed) {
        this.leftMotorMaster.set(speed);
    }

    public void setRight(double speed) {
        this.rightMotorMaster.set(speed);
    }

    public void stop() {
        this.leftMotorMaster.stopMotor();
        this.rightMotorMaster.stopMotor();
    }
}