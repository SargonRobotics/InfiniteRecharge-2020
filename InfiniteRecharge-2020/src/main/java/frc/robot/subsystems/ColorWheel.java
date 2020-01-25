package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.Constants;

public class ColorWheel extends SubsystemBase {
    Victor colorWheelMotor;
    Encoder wheelEncoder;

    public ColorWheel() 
    {
        colorWheelMotor = new Victor(Constants.COLOR_WHEEL_MOTOR);
        wheelEncoder = new Encoder(Constants.COLOR_WHEEL_ENCODER_A, Constants.COLOR_WHEEL_ENCODER_B);
    }

    public int getRotations(){
        return wheelEncoder.getRaw();
    }

    public void turnWheel()
    {
        colorWheelMotor.set(1);
    }

    public void stopWheel()
    {
        colorWheelMotor.set(0);
    }

    @Override
    public void periodic()
    {


    }

}