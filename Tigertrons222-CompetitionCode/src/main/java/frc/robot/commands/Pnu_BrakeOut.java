/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.PnuBrakeSubsystem;


/**
 * A command that releases the hatch.
 */
public class Pnu_BrakeOut extends InstantCommand {
  public Pnu_BrakeOut(PnuBrakeSubsystem subsystem) {
    super(subsystem::deploySolenoid, subsystem);
  }
}
