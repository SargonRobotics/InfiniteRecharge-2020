/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  Spark frontRight, backRight, frontLeft, backLeft;
  DifferentialDrive driveTrain; 
  /**
   * Creates a new Drive.
   */
  public Drive() {
    frontRight = new Spark(Constants.FRONT_RIGHT_MOTOR);
    
    frontLeft = new Spark(Constants.FRONT_LEFT_MOTOR);
    

    driveTrain = new DifferentialDrive(frontLeft, frontRight);
  }

  public void drive(double xSpeed, double zRotation){
    driveTrain.arcadeDrive(xSpeed, zRotation);
  }
  
  public void stop(){
    driveTrain.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
