package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Conveyor_Intake extends CommandBase {
  private final Conveyor m_subsystem;

  double SpeedPoint;

  public Conveyor_Intake(double Speed) {
    SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_conveyor;
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