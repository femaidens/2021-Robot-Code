// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import java.util.ArrayList;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class ColorWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  public CANSparkMax colorMotor = new CANSparkMax(RobotMap.colorMotorPort, MotorType.kBrushless);
  public DoubleSolenoid colorPiston = new DoubleSolenoid(RobotMap.colorPistonPort1, RobotMap.colorPistonPort2);
  public ColorSensorV3 colorSensorV3 = new ColorSensorV3(i2cPort);
  public final ColorMatch m_colorMatcher = new ColorMatch();
  
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  public ArrayList<Color> list = new ArrayList<Color>();
  
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
