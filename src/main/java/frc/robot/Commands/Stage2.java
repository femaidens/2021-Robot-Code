// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;

public class Stage2 extends Command {
  int count = 0;
  Color initialColor;
  ColorMatchResult match;
  Color detectedColor;

  public Stage2() {
    requires(Robot.colorWheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	//Get the initial color sent from the sensor
	Color col = Robot.colorWheel.colorSensorV3.getColor(); 
	//Match the color to one of the four options inside colorMatch
	initialColor = Robot.colorWheel.m_colorMatcher.matchClosestColor(col).color; 
	Robot.colorWheel.spinWheel();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    detectedColor = Robot.colorWheel.colorSensorV3.getColor();
    match = Robot.colorWheel.m_colorMatcher.matchClosestColor(detectedColor);
    if(match.color == initialColor){
	    count++; 
    } 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (count==7);
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
