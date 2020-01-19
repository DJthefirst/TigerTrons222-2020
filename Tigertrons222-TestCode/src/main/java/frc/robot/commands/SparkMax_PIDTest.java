package frc.robot.commands;

import frc.robot.subsystems.SparkMaxTest;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparkMax_PIDTest extends CommandBase {
  private final SparkMaxTest m_subsystem;

  public SparkMax_PIDTest(SparkMaxTest subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }
  double point = 600;
  
  @Override
  public void execute() {

  m_subsystem.turnPID(point);
  System.out.println(m_subsystem.getDriveEncoder().getVelocity());
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}