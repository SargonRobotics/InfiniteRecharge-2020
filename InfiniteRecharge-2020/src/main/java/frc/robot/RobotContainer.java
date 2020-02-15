/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TurnWheel10;
import frc.robot.commands.TurnWheelToColor;
import frc.robot.commands.DeployBallVac;
import frc.robot.commands.Shoot;
import frc.robot.commands.VacToggle;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();


  Joystick joystick;
  JoystickButton turnButton;
  JoystickButton sensorButton; 
  JoystickButton shootButton;
  JoystickButton vacButton;
  JoystickButton pistonButton;

  private final ColorWheel m_colorwheel = new ColorWheel();
  private final ColorSensor m_colorsensor = new ColorSensor();
  private final Shooter m_shooter = new Shooter();
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    joystick = new Joystick(Constants.JOYSTICK);
    turnButton = new JoystickButton(joystick, Constants.TURN_BUTTON);
    sensorButton = new JoystickButton(joystick, Constants.SENSOR_BUTTON);
    shootButton = new JoystickButton(joystick, Constants.SHOOT_BUTTON);
    vacButton = new JoystickButton(joystick, Constants.VAC_BUTTON);
    pistonButton = new JoystickButton(joystick, Constants.PISTON_BUTTON);

    turnButton.whenPressed(new TurnWheel10(m_colorwheel));
    sensorButton.whenPressed(new TurnWheelToColor(m_colorwheel, m_colorsensor));
    shootButton.toggleWhenPressed(new Shoot(m_shooter));
    vacButton.toggleWhenPressed(new VacToggle(m_shooter));
    pistonButton.whenPressed(new DeployBallVac(m_shooter));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
