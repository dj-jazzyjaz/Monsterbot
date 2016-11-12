package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TraverseDrive extends Command {
	private boolean setPneumatics;
	private String direction;
	private double speed;
    public TraverseDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.traverseSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drivetrain.compressor.setClosedLoopControl(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double l = Robot.oi.stick.getRawAxis(OI.Axis.LTrigger.getAxisNumber());
    	double r = Robot.oi.stick.getRawAxis(OI.Axis.RTrigger.getAxisNumber());
    	SmartDashboard.putNumber("Left Stick", l);
    	SmartDashboard.putNumber("Right Stick", r);
    	
    	/*if(l<0.05){
    		l=0;
    	}
    	
    	if (r<0.05){
    		r=0;
    	}*/
    	SmartDashboard.putNumber("Left Traverse", l);
    	SmartDashboard.putNumber("Right Traverse", r);
    	Robot.traverseSystem.traverseDrive(r, l);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.compressor.setClosedLoopControl(false);
    //	Robot.drivetrain.setPneumatics(false, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
