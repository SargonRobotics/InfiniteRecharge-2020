/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ColorWheel;
import frc.robot.Robot;
import frc.robot.subsystems.ColorSensor;

public class TurnWheelToColor extends CommandBase {
  private String targetColor;
  private String colorInput;
  /**
   * Creates a new TurnWheelToColor.
   */
  private final ColorWheel wheel;
  private final ColorSensor sensor;

  public TurnWheelToColor(ColorWheel S_wheel, ColorSensor S_sensor)
  { 
    wheel = S_wheel;
    sensor = S_sensor;

    addRequirements(wheel);
    addRequirements(sensor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //targetColor = DriverStation.getInstance().getGameSpecificMessage();
    targetColor = "R";
    wheel.resetRotations();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    wheel.turnWheel();
    colorInput = sensor.matchColor(sensor.getColor());
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    wheel.stopWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    
    if(targetColor == colorInput)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
}
