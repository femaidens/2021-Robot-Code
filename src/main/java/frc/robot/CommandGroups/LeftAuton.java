// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class LeftAuton extends CommandGroup {
  /** Add your docs here. */
  public LeftAuton() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    addSequential(new DriveStraightDistance(30)); //distance is tentative cross line and get balls (maybe 2 sec)
		addParallel(new In(), 4); //get balls 
    addSequential(new DriveStraightDistance(10));
		addSequential(new TurnDegrees(180)); //turn around
		addSequential(new DriveStraightDistance(10)); //go a bit towards the wall
    addSequential(new TurnDegrees(-90)); //counter 90 to align to where we shoot
    addSequential(new DriveStraightDistance(10)); //go straight to align
    addSequential(new TurnDegrees(90)); //clockwise 90 to face wall again
    addSequential(new DriveStraightDistance(10)); //go to the wall (getting to the wall 4 sec hopefully)
		addSequential(new Shoot(), 5); //shoot for some time
  }
}
