package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        wheelEncoder.setDistancePerPulse(-1./500.);
    }

    public double getRotations(){
        return wheelEncoder.getDistance();
    }

    public void resetRotations()
    {
        wheelEncoder.reset();
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
        SmartDashboard.putNumber("Raw color Wheel", wheelEncoder.getRaw());
        SmartDashboard.putNumber("Color Wheel Turns", getRotations());

    }

}