package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Turret_SetSpeed extends CommandBase {
  private final Turret m_subsystem;

  double SpeedPoint;

  public Turret_SetSpeed(double Speed) {
    SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_turret;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    m_subsystem.spinSpeedPID(SpeedPoint);

  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.spinSpeed(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}