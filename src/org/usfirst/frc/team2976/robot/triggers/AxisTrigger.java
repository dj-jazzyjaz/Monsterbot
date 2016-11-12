package org.usfirst.frc.team2976.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AxisTrigger extends Trigger {
	public double axis;
	public Command command;
	public AxisTrigger(double axis, Command command){
		this.axis = axis;
		this.command = command;
		whenActive();
	}
    public void whenActive(){    
		SmartDashboard.putNumber("vishal", axis);
    	if(axis != 0){
    		command.start();
    	} else {
    		command.cancel();
    	}
    }
    public boolean get() {
        return false;
    }
}
