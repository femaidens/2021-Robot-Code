// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;
import frc.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightDistance extends Command {

  private double dist;

  public DriveStraightDistance(double d) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
		dist = d;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.frontRight.setSelectedSensorPosition(0.0);
		Robot.drivetrain.frontLeft.setSelectedSensorPosition(0.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.driveStraight();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return(Robot.drivetrain.frontRight.getSelectedSensorPosition() >= dist && Robot.drivetrain.frontLeft.getSelectedSensorPosition() >=  dist);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrain.stop();
  }
}
