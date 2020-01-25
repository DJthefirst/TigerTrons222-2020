package frc.robot.commands;

import frc.robot.subsystems.SparkMaxTest;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparkMax_DefaultTest extends CommandBase {
  private final SparkMaxTest m_subsystem;

  public SparkMax_DefaultTest(SparkMaxTest subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  //double turnSpeed = RobotContainer.Controller.getRawAxis(3);
  //double turnSpeed = .1;
  m_subsystem.readEncoderAUX();
  //m_subsystem.turn(turnSpeed);
  //System.out.println(m_subsystem.getDriveEncoder().getVelocity());
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}