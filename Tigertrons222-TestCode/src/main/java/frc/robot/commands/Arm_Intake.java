package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Arm_Intake extends CommandBase {
    private final Arm m_subsystem;

    double SpeedPoint;

    public Arm_Intake(double Speed) {
    SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_arm;
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
    m_subsystem.spinSpeedPID(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}