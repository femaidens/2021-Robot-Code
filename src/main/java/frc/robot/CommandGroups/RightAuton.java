// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class RightAuton extends CommandGroup {
  /** Add your docs here. */
  public RightAuton() {
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
