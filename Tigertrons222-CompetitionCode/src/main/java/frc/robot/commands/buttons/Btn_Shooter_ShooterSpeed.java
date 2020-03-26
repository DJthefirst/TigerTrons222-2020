package frc.robot.commands.buttons;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Btn_Shooter_ShooterSpeed extends CommandBase {
    private final Shooter m_subsystem;

    NetworkTable table;
    double SpeedPoint = 0;


    public Btn_Shooter_ShooterSpeed(double Speed) {
    SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_Shooter;
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