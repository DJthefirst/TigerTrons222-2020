package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Turret_Rotation extends CommandBase {
    private final Turret m_subsystem;
    
    double SpeedPoint;

    public Turret_Rotation() {

    m_subsystem = RobotContainer.m_turret;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    double turretencoder = m_subsystem.getEncoder();
    if (turretencoder<0.5 && turretencoder>0.0){
       SpeedPoint = 0;
    }
    else {
        SpeedPoint = 0.3;
    }
    m_subsystem.rotationspeed (SpeedPoint);
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}