package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;

public class ColorWheel extends SubsystemBase {
    Spark colorWheelMotor;
    Encoder wheelEncoder;

    public ColorWheel() 
    {
        colorWheelMotor = new Spark(Constants.COLOR_WHEEL_MOTOR);
        wheelEncoder = new Encoder()
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