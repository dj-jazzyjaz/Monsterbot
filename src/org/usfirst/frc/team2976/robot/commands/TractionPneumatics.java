package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TractionPneumatics extends Command {
	//public boolean on;
	private boolean set;
    public TractionPneumatics(boolean set) {
        requires(Robot.drivetrain);
        //this.on = on;
        this.set = set;
    }

    protected void initialize() {
    	//Robot.drivetrain.setCompressor(true);
    	Robot.drivetrain.setTopPneumatics(set);
    }

    protected void execute() {
//    	SmartDashboard.putBoolean("Pneumatics command", true);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	SmartDashboard.putBoolean("Pneumatics command off", true);
    	
    }
    
    protected void interrupted() {
    	end();
    }
}