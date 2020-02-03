/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class TurnWheel10 extends CommandBase {
  private static final int maxRotations = 5;
  /**
   * Creates a new TurnWheel10.
   */
  private final ColorWheel colorWheel;
  private double rotations;

  
  public TurnWheel10(ColorWheel S_wheel) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorWheel = S_wheel;
    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    colorWheel.resetRotations();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    colorWheel.turnWheel();
    rotations = colorWheel.getRotations();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    colorWheel.stopWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return (rotations >= maxRotations);
  }
}
