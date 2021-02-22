// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Commands.*;
import frc.robot.Subsystems.*;

/** Add your docs here. */
public class Intake extends Subsystem {

  public DoubleSolenoid intakePiston = new DoubleSolenoid(RobotMap.intakePistonPort1, RobotMap.intakePistonPort2);
	public CANSparkMax intakeNEO = new CANSparkMax(RobotMap.intakeNEOPort, MotorType.kBrushless);

	public Intake(){
	}
	public void extend(){
		intakePiston.set(DoubleSolenoid.Value.kForward);
	}
	public void retract(){
		intakePiston.set(DoubleSolenoid.Value.kReverse);
	}
	public void in(){
		if(Robot.hopper.ballCount < 5){ 
			intakeNEO.set(1.0); 
		} else{
			stop();
		}
	}
	public void out(){
		intakeNEO.set(-1.0);
	}
	public void stop(){
		intakeNEO.set(0.0);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
