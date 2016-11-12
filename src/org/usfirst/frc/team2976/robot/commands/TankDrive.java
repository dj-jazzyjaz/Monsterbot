package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double r = Robot.oi.stick.getRawAxis(OI.Axis.RY.getAxisNumber());
    	double l = Robot.oi.stick.getRawAxis(OI.Axis.LY.getAxisNumber());
    	
    	SmartDashboard.putNumber("Right Drive", r);
    	SmartDashboard.putNumber("Left Drive", l);
    	
    /*	if (r<0.25 && r>-0.25){
    		r=0;
    	}
    	
    	if(l<0.25 && l>-0.25){
    		l=0;
    	}*/
    	Robot.drivetrain.tankDrive(r, l);   	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
