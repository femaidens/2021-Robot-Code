// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Robot;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CANSparkMax shooterNEO = new CANSparkMax(RobotMap.shooterNEOPort, MotorType.kBrushless);
	public CANSparkMax hopperExit1 = new CANSparkMax(RobotMap.hopperExit1Port, MotorType.kBrushless);
	public CANSparkMax hopperExit2 = new CANSparkMax(RobotMap.hopperExit2Port, MotorType.kBrushless);

	public CANPIDController pidController = shooterNEO.getPIDController();

	private final double yDisplacement = 0;
	//private final double xDisplacement;
  private final double angle = 0;
  
  public Shooter(){
		pidController.setP(0.0);
		pidController.setI(0.0);
		pidController.setD(0.0);
    pidController.setOutputRange(0.1, 1.0); 
    pidController.setFF(0.0);
    pidController.setIZone(0.0);
  }

  public void spinWheel() {	
    hopperExit1.set(0.8);	
    hopperExit2.set(0.8);
    double speed = calculateSpeed();
    pidController.setReference(speed, ControlType.kVelocity);
  }
    
  public void stop() {
    shooterNEO.set(0.0);
    hopperExit1.set(0.0);
    hopperExit2.set(0.0);
  }
    
  public double calculateSpeed(){ 
    double y_speed = Math.sqrt(19.6 * yDisplacement);
    double speed = y_speed/Math.sin(angle);

    //speed /= radius;
    return speed;
  }
    

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
