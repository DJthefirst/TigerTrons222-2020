package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Pnu3Subsystem;

/**
 * A simple command that grabs a hatch with the {@link HatchSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class Pnu_3In extends CommandBase {
  // The subsystem the command runs on
  private final Pnu3Subsystem m_subsystem;

  public Pnu_3In(Pnu3Subsystem subsystem) {
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
