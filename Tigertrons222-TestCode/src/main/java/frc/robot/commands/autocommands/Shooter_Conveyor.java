package frc.robot.commands.autocommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter_Conveyor extends CommandBase {
  private final Shooter m_subsystem;

  double SpeedPoint;
  double intakeSpeed;

  public Shooter_Conveyor(double Speed,double IntakeSpeed) {
    SpeedPoint = Speed;
    intakeSpeed = IntakeSpeed;
    m_subsystem = RobotContainer.m_Shooter;
  
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    m_subsystem.spinSpeedPID(SpeedPoint);

    if (Math.abs(m_subsystem.getShooterSpeed()) > Math.abs(SpeedPoint*.95)){
      RobotContainer.m_conveyor.spinSpeedPID(intakeSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.spinSpeed(0);
    RobotContainer.m_conveyor.turn(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}