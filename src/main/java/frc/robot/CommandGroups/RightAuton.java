// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class RightAuton extends CommandGroup {
  /** Add your docs here. */
  public RightAuton() {
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
    addSequential(new DriveStraightDistance(10)); //drive to cross line
		addSequential(new TurnDegrees(-90)); //turn left
		addSequential(new DriveStraightDistance(10)); //drive forward until in front of goal
		addSequential(new TurnDegrees(-90)); //turn towards goal
		addSequential(new DriveStraightDistance(10)); //go up to wall in order to shoot
		addSequential(new Shoot(), 3); //shoot ball
		addSequential(new DriveStraightDistance(10)); //back up from wall
		addSequential(new TurnDegrees(180)); //turn around to face climb area

    addSequential(new TurnDegrees(45)); // guesstimate degrees
		addParallel(new In(), 0.8); 
    addSequential(new DriveStraightDistance(10)); // distance to the corner of the rendezvous
  }
}
