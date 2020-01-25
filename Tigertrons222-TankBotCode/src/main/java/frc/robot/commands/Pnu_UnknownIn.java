package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.PnuUnknownSubsystem;


public class Pnu_UnknownIn extends CommandBase {
  
  private final  PnuUnknownSubsystem m_subsystem;

  public Pnu_UnknownIn(PnuUnknownSubsystem subsystem) {
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
