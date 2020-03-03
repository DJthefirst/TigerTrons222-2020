package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.PnuUnknownSubsystem;



public class Pnu_HopperOut extends InstantCommand {
  public Pnu_HopperOut(PnuUnknownSubsystem subsystem) {
    super(subsystem::deploySolenoid, subsystem);
  }
}
