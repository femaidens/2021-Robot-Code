// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Commands.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public CANSparkMax rightNEO = new CANSparkMax(RobotMap.rightNEOPort, MotorType.kBrushed);
  public CANSparkMax leftNEO = new CANSparkMax(RobotMap.leftNEOPort, MotorType.kBrushed);
  public DoubleSolenoid leftPiston = new DoubleSolenoid(RobotMap.leftPistonPort1, RobotMap.leftPistonPort2);
  public DoubleSolenoid rightPiston = new DoubleSolenoid(RobotMap.rightPistonPort1, RobotMap.rightPistonPort2);

  public Climb(){
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new MoveArms());
  }

  public void extend(){
    leftPiston.set(DoubleSolenoid.Value.kForward);
    rightPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void retract(){
    rightPiston.set(DoubleSolenoid.Value.kReverse);
    leftPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void moveArms(){
    double armJoy = OI.operJoy.getRawAxis(1);	
    rightNEO.set(armJoy);
    leftNEO.set(armJoy);
  }

  public void moveArmsDown(){
    Robot.drivetrain.driveStraight();
  }

  public void stop(){
	  rightNEO.set(0.0);
	  leftNEO.set(0.0);
  }
}
