// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.util.Color;

import java.util.Scanner;

import com.revrobotics.ColorMatchResult;

public class Stage3 extends Command {
  Color target;

  public Stage3() {
    requires(Robot.colorWheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Scanner scan = new Scanner(System.in); 
    System.out.println("Enter the index (the first index is 0): ");
    int index = scan.nextInt();
    target = Robot.colorWheel.list.get((index + 2) % 4);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.colorWheel.spinWheel();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    Color col = Robot.colorWheel.colorSensorV3.getColor();
    ColorMatchResult match = Robot.colorWheel.m_colorMatcher.matchClosestColor(col);
    return match.color == target;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.colorWheel.stopWheel();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.colorWheel.stopWheel();

  }
}
