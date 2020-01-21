package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {
    Spark colorWheelMotor;
    Encoder wheelEncoder;

    public ColorWheel() 
    {
        colorWheelMotor = new Spark(Constants.COLOR_WHEEL_MOTOR);
        wheelEncoder = new Encoder(COLOR_WHEEL_ENCODER_A, COLOR_WHEEL_ENCODER_B)
    }

    public void TurnWheel()
    {
        colorWheelMotor.set(1);
    }

    public void StopWheel()
    {
        colorWheelMotor.set(0);
    }

    @Override
    public void periodic()
    {


    }

}