package frc.robot.commands;

import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Conveyor_Default extends CommandBase {
  private final Conveyor m_subsystem;

  public Conveyor_Default(Conveyor subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    m_subsystem.turnPID(1000);

  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.turnPID(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}