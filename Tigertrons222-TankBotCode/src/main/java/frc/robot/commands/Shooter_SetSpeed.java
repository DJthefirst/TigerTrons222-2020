package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterWheels;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter_SetSpeed extends CommandBase {
  private final ShooterWheels m_subsystem;

  double leftSpeedPoint;
  double rightSpeedPoint;

  public Shooter_SetSpeed(double leftSpeed, double rightSpeed) {
    leftSpeedPoint = leftSpeed;
    rightSpeedPoint = rightSpeed;
    m_subsystem = RobotContainer.m_shooter;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    m_subsystem.spinSpeedPID(leftSpeedPoint,rightSpeedPoint);

  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.spinSpeedPID(0,0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}