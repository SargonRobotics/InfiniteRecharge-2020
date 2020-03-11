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

    public void resetRotations() {
       
    }
    

    @Override
    public void periodic()
    {


    }

	

}