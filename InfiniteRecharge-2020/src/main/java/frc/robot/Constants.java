/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    // Motor ports
    public static final int FRONT_LEFT_MOTOR = 1;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int BACK_LEFT_MOTOR = 3;
    public static final int BACK_RIGHT_MOTOR = 4;
    // joystick and axis ports
    public static final int JOYSTICK = 0;
    public static final int X_AXIS = 0;
    public static final int Y_AXIS = 1;
    public static final int Z_AXIS = 4;

    //Button Ports
    public static final int TURN_BUTTON = 3;
    public static final int SENSOR_BUTTON = 2;

    public static ColorThreshold redThreshold = new ColorThreshold(0.45, 0.3, 0.1);
    public static ColorThreshold greenThreshold = new ColorThreshold(0.2, .55, 0.2);
    public static ColorThreshold blueThreshold = new ColorThreshold(0.1, 0.2, 0.3);
    public static ColorThreshold yellowThreshold = new ColorThreshold(0.3, 0.5, 0.1);

    //Port for color wheel spinner
    public static final int COLOR_WHEEL_MOTOR = 5; 
    public static final int COLOR_WHEEL_ENCODER_A = 0;
    public static final int COLOR_WHEEL_ENCODER_B = 1;

    public static final int BALL_VAC_MOTOR = 5;
    public static final int SHOOTER_MOTOR = 6;

    
}
