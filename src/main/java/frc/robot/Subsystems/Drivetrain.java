// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.Commands.DriveTeleop;

/** Add your docs here. */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

	public TalonFX frontRight = new TalonFX(RobotMap.frontRightPort);
	public TalonFX frontLeft = new TalonFX(RobotMap.frontLeftPort);
	public TalonFX middleLeft = new TalonFX(RobotMap.middleLeftPort);
	public TalonFX rearRight = new TalonFX(RobotMap.rearRightPort);
	public TalonFX rearLeft = new TalonFX(RobotMap.rearLeftPort);
	public TalonFX middleRight = new TalonFX(RobotMap.middleRightPort);

	public AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
  
 	 public final int PID_TYPE = 0;
 	 public final int DEFAULT_TIMEOUT = 5;

public Drivetrain() {
	frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	middleRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	rearRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	middleLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	rearLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, PID_TYPE, DEFAULT_TIMEOUT);
	}

  	@Override
  	public void initDefaultCommand() {
   	 // Set the default command for a subsystem here.
   	 // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveTeleop());
 	 }
  
public void driveTeleop(){
	double leftJoy = OI.driveJoy.getRawAxis(1);
	double rightJoy = OI.driveJoy.getRawAxis(5);
	frontLeft.set(ControlMode.PercentOutput, leftJoy);
   	middleLeft.set(ControlMode.PercentOutput, leftJoy);
  	rearLeft.set(ControlMode.PercentOutput, leftJoy);
	frontRight.set(ControlMode.PercentOutput, rightJoy);
	middleRight.set(ControlMode.PercentOutput, rightJoy);
  	rearRight.set(ControlMode.PercentOutput, rightJoy);
  }

  public void auton(double speed){
    frontRight.set(ControlMode.PercentOutput, speed);
    frontLeft.set(ControlMode.PercentOutput, speed);
    middleRight.set(ControlMode.PercentOutput, speed);
    middleLeft.set(ControlMode.PercentOutput, speed);
    rearRight.set(ControlMode.PercentOutput, speed);
    rearLeft.set(ControlMode.PercentOutput, speed);
  }

  public void driveStraight(){
    if(frontLeft.getSelectedSensorPosition() > frontRight.getSelectedSensorPosition()){
      frontRight.set(ControlMode.PercentOutput, 0.8);
      middleRight.set(ControlMode.PercentOutput, 0.8);
      rearRight.set(ControlMode.PercentOutput, 0.8);
      frontLeft.set(ControlMode.PercentOutput, 0.5);
      middleLeft.set(ControlMode.PercentOutput, 0.5);
      rearLeft.set(ControlMode.PercentOutput, 0.5);
    } else if(frontLeft.getSelectedSensorPosition() < frontRight.getSelectedSensorPosition()) {
      frontRight.set(ControlMode.PercentOutput, 0.5);
      middleRight.set(ControlMode.PercentOutput, 0.5);
      rearRight.set(ControlMode.PercentOutput, 0.5);
      frontLeft.set(ControlMode.PercentOutput, 0.8);
      middleLeft.set(ControlMode.PercentOutput, 0.8);
      rearLeft.set(ControlMode.PercentOutput, 0.8);
    } else {
      frontRight.set(ControlMode.PercentOutput, 0.8);
      middleRight.set(ControlMode.PercentOutput, 0.8);
      rearRight.set(ControlMode.PercentOutput, 0.8);
      frontLeft.set(ControlMode.PercentOutput, 0.8);
      middleLeft.set(ControlMode.PercentOutput, 0.8);
      rearLeft.set(ControlMode.PercentOutput, 0.8);
    }
  }

  public void turnDegrees(double angle){
    if(angle > 180){
      angle = -(360-angle);
    }

    while(gyro.getAngle() != angle){
        if (gyro.getAngle() < angle) {
          frontRight.set(ControlMode.PercentOutput, -0.5);
          frontLeft.set(ControlMode.PercentOutput, 0.5);
          middleRight.set(ControlMode.PercentOutput, -0.5);
          middleLeft.set(ControlMode.PercentOutput, 0.5);
          rearRight.set(ControlMode.PercentOutput, -0.5);
          rearLeft.set(ControlMode.PercentOutput, 0.5);
        } else {
          frontRight.set(ControlMode.PercentOutput, 0.5);
          frontLeft.set(ControlMode.PercentOutput, -0.5);
          middleRight.set(ControlMode.PercentOutput, 0.5);
          middleLeft.set(ControlMode.PercentOutput, -0.5);
          rearRight.set(ControlMode.PercentOutput, 0.5);
          rearLeft.set(ControlMode.PercentOutput, -0.5);
      }
    }
	}

public void stop(){
	frontRight.set(ControlMode.PercentOutput, 0.0);
	frontLeft.set(ControlMode.PercentOutput, 0.0);
	middleRight.set(ControlMode.PercentOutput, 0.0);
	middleLeft.set(ControlMode.PercentOutput, 0.0);
	rearRight.set(ControlMode.PercentOutput, 0.0);
	rearLeft.set(ControlMode.PercentOutput, 0.0);
  } 
}
