// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.Commands.*;
import frc.robot.Subsystems.*;

/** Add your docs here. */
public class OI {
    public static Joystick driveJoy = new Joystick(RobotMap.drivePort);
	public static Joystick operJoy = new Joystick(RobotMap.operPort);
	public static Button armsDown = new JoystickButton(operJoy, 1);
	public static Button shoot = new JoystickButton(operJoy, 2);
	public static Button extend = new JoystickButton(operJoy, 3);
	public static Button retract = new JoystickButton(operJoy, 3);
    public static Button in = new JoystickButton(driveJoy, 1);
    public static Button out = new JoystickButton(driveJoy, 2);
    public static Button stage2 = new JoystickButton(operJoy, 4);
    public static Button stage3 = new JoystickButton(operJoy, 5);

    public OI(){

    }
    
    public static void bindButtons(){
        armsDown.whenPressed(new ArmsDown()); 
        shoot.whileHeld(new Shoot());
        extend.toggleWhenPressed(new Extend());	
        retract.toggleWhenPressed(new Retract());
        in.whileHeld(new In());
        out.whileHeld(new Out());
        stage2.whenPressed(new Stage2());
        stage3.whenPressed(new Stage3());
        
    }
}
