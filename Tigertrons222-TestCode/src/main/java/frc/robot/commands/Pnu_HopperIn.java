package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PnuHopperSubsystem;

public class Pnu_HopperIn extends CommandBase {

  private final PnuHopperSubsystem m_subsystem;

  public Pnu_HopperIn(PnuHopperSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    m_subsystem.retractSolenoid();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
