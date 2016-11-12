package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Compressor compressor = new Compressor(); 
	public Solenoid topPneumatics;
	public Solenoid botPneumatics;
	public DoubleSolenoid doublePneumatics;
	
	private SpeedController rightMotor1, rightMotor2, rightMotor3;
	private SpeedController leftMotor1, leftMotor2, leftMotor3;
	
	
	    
	public RobotDrive m_drive;
	public DriveTrain()	{
		
    	rightMotor1 = new Victor(RobotMap.RightMotor1);
    	rightMotor2 = new Victor(RobotMap.RightMotor2);
    	rightMotor3 = new Victor(RobotMap.RightMotor3);
    	leftMotor1 = new Victor(RobotMap.LeftMotor1);
    	leftMotor2 = new Victor(RobotMap.LeftMotor2);
    	leftMotor3 = new Victor(RobotMap.LeftMotor3);
    	
    	topPneumatics = new Solenoid(RobotMap.TopSolenoid);
    	botPneumatics = new Solenoid(RobotMap.BottomSolenoid);    	
    	
    	
    	//m_drive =  new RobotDrive(leftBackMotor, leftFrontMotor,rightBackMotor, rightFrontMotor);
 
	}
	public void tankDrive(double r_speed, double l_speed){
		double rightspeed = r_speed;
		double leftspeed = l_speed;
     	
     	SmartDashboard.putNumber("Rightspeed", rightspeed);
     	SmartDashboard.putNumber("Leftspeed", leftspeed);
     	
     	rightMotor1.set(rightspeed);
     	rightMotor2.set(-rightspeed);
     	rightMotor3.set(-rightspeed);
     	leftMotor1.set(leftspeed);
     	leftMotor2.set(-leftspeed);
     	leftMotor3.set(leftspeed);
	}
	
	
	public void setCompressor(boolean on){
		compressor.setClosedLoopControl(on);
	}
	/*public void setPneumatics(boolean top, boolean on){
		if(top){
			topPneumatics.set(true);
		} else {
			botPneumatics.set(false);
		}
	}*/
	
	/*public void setTopPneumatics (boolean pOut){
		if(pOut){
			topPneumatics.set(true);
		} else {
			topPneumatics.set(false);
		}
	}*/
	
	public void setTopPneumatics (boolean set){
		topPneumatics.set(set);
    	SmartDashboard.putBoolean("Top pneumatics command", set);
	}
	public void setBotPneumatics (boolean set){
		botPneumatics.set(set);
	}
//	public void setDoublePneumaticsF () {
//		doublePneumatics.set(DoubleSolenoid.Value.kForward);
//	}
//	
//	public void setDoublePneumaticsR () {
//		doublePneumatics.set(DoubleSolenoid.Value.kReverse);
//	}
//	
//	public void setDoublePneumaticsO () {
//		doublePneumatics.set(DoubleSolenoid.Value.kOff);
//	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}

