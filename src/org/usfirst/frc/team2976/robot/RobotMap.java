package org.usfirst.frc.team2976.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    public static final int TopSolenoid = 0;
    public static final int BottomSolenoid = 1;
    public static final int RightMotor1 = 2;
    public static final int RightMotor2 = 5;
    public static final int RightMotor3 = 6;
    public static final int LeftMotor1 = 1;
    public static final int LeftMotor2 = 4;
    public static final int LeftMotor3 = 3;
    public static final int TraverseMotor1 = 7;
    public static final int TraverseMotor2 = 8;
    		
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
