// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

/** Add your docs here. */
public class ColorWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public CANSparkMax colorMotor = new CANSparkMax(RobotMap.colorMotorPort, MotorType.kBrushless);
  public DoubleSolenoid colorPiston = new DoubleSolenoid(RobotMap.colorPistonPort1, RobotMap.colorPistonPort2);
  public ColorSensorV3 colorSensorV3 = new ColorSensorV3(RobotMap.colorSensorPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  private ArrayList<Color> list = ArrayList<Color>();
  
  public ColorWheel(){
    list.add(kBlueTarget);
    list.add(kGreenTarget);
    list.add(kRedTarget);
    list.add(kYellowTarget);
  
     m_colorMatcher.addColorMatch(kBlueTarget);
     m_colorMatcher.addColorMatch(kGreenTarget);
     m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget); 

  }
  
  public void spinWheel() {
    colorMotor.set(0.8);
  }
  
  public void stopWheel(){
     colorMotor.set(0.0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
