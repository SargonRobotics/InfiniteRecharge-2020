package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    Spark ballVac;
    Spark shooterMotor;

    public Shooter(){
        ballVac = new Spark(Constants.BALL_VAC_MOTOR);
        shooterMotor = new Spark(Constants.SHOOTER_MOTOR);
    }

    public void toggleVac(boolean status){


    }
}