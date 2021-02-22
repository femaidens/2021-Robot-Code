// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.RobotMap;
import frc.robot.Commands.*;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Hopper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public CANSparkMax hopperNEO = new CANSparkMax(RobotMap.hopperNEOPort, MotorType.kBrushless);
	public Ultrasonic in = new Ultrasonic(RobotMap.inPort1, RobotMap.inPort2);
	public Ultrasonic out = new Ultrasonic(RobotMap.outPort1, RobotMap.outPort2);
	public CANEncoder hopEncoder = hopperNEO.getEncoder();
	
	public int ballCount = 3;
	private final double distance = 10; //distance in mm between the ultrasonic and the other side of the hopper

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Counting());
  }

  public void spin(){
    hopperNEO.set(0.4);
  }

	public void stop(){
		hopperNEO.set(0.0);
	}

  public void countIn(){
		spin();
		if (in.getRangeMM() < distance){ 			
      ballCount++;
    }
  }
    
  public void countOut(){
    if (out.getRangeMM() < distance && ballCount > 0){ 
      ballCount--;
    }
  }
}

