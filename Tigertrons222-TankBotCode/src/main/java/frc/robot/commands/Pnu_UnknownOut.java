package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.PnuUnknownSubsystem;



public class Pnu_UnknownOut extends InstantCommand {
  public Pnu_UnknownOut(PnuUnknownSubsystem subsystem) {
    super(subsystem::deploySolenoid, subsystem);
  }
}
