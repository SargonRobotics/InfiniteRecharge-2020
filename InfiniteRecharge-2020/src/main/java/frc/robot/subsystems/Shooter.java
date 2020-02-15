package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    Spark ballVac;
    Spark shooterMotor;

    Solenoid leftPiston;
    Solenoid rightPiston;

    public Shooter(){
        ballVac = new Spark(Constants.BALL_VAC_MOTOR);
        shooterMotor = new Spark(Constants.SHOOTER_MOTOR);

        leftPiston = new Solenoid(Constants.LEFT_PISTON);
        rightPiston = new Solenoid(Constants.RIGHT_PISTON);
    }

    public void StartVac(){
        ballVac.set(1);
    }
    public void StopVac(){
        ballVac.set(0);
    }
    public void StartShoot(){
        shooterMotor.set(1);
    }
    public void StopShoot(){
        shooterMotor.set(0);
    }

    public void togglePistons()
    {
        boolean left = leftPiston.get();
        boolean right = rightPiston.get();
        
        leftPiston.set(!left);
        rightPiston.set(!right);
    }

}