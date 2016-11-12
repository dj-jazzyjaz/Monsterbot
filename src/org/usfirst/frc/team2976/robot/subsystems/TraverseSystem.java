package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.TraverseDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TraverseSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController traverseMotor1, traverseMotor2;
	
	public TraverseSystem(){
		traverseMotor1 = new Talon(RobotMap.TraverseMotor1);
    	traverseMotor2 = new Talon(RobotMap.TraverseMotor2);
	}
//	
	public void traverseDrive(double right, double left){
		if (right > 0.05 && left < 0.05){
			Robot.drivetrain.setBotPneumatics(true);
			traverseMotor1.set(right);
			traverseMotor2.set(-right);
		} else if (left > 0.05 && right < 0.05){
			Robot.drivetrain.setBotPneumatics(true);
			traverseMotor1.set(-left);
			traverseMotor2.set(left);
		} else if (left == 0 && right == 0){
			Robot.drivetrain.setBotPneumatics(false);
			traverseMotor1.set(0);
			traverseMotor2.set(0);
		}
//		
//		/*GOING RIGHT:
//		if (right > 5){
//		traverseMotor1.set(right);
//		traverseMotor2.set(-right);} */
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TraverseDrive());
    }
}

