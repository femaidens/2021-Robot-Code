// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
package frc.robot.Commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmsDown extends Command {
  private final double dist = 100; //measure distance to climb
  public ArmsDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.climb.extend();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.moveArmsDown();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return(Robot.drivetrain.frontRight.getSelectedSensorPosition() >= dist && Robot.drivetrain.frontLeft.getSelectedSensorPosition() >=  dist);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climb.stop();
    Robot.drivetrain.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climb.stop();
    Robot.drivetrain.stop();

  }
}
