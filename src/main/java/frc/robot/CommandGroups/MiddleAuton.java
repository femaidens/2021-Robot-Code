// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class MiddleAuton extends CommandGroup {
  /** Add your docs here. */
  public MiddleAuton() {
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
    addSequential(new DriveStraightDistance(10)); // distance to the corner of the rendezvous
    addSequential(new TurnDegrees(-45));
    addParallel(new In(), 2);
    addSequential(new DriveStraightDistance(10)); // distance to intake two ball 
    addSequential(new TurnDegrees(180));
    addSequential(new DriveStraightDistance(10)); // distance to corner of rendezvous - same corner as before
    addSequential(new TurnDegrees(45)); // turning to be perpendicular to the wall w/ goal
    addSequential(new DriveStraightDistance(10)); // driving distance to initiation line
    addSequential(new TurnDegrees(90)); 
    addSequential(new DriveStraightDistance(10)); // drive until you are in front of goal on initiation line
    addSequential(new TurnDegrees(-90));
    addSequential(new DriveStraightDistance(10)); // drive until you reach the wall
    addSequential(new Shoot(), 5);
  }
}
