package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Turret_Rotation extends CommandBase {
    private final Turret m_subsystem;
    
    double AngleTarget;
    double SpeedPoint;

  public Turret_Rotation(double target){
    AngleTarget = target;
    m_subsystem = RobotContainer.m_turret;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    final double turretencoder = m_subsystem.getEncoder();

    // if (turretencoder < (AngleTarget- (Constants.turretAngleError / 2))) {
    //   SpeedPoint = -.4;
    // }
    // else if(turretencoder > (AngleTarget+ (Constants.turretAngleError / 2))){
    //   SpeedPoint = .4;
    // }
    // else{
    //   SpeedPoint = 0;
    // }
    m_subsystem.turretPID (SpeedPoint);
  }

  @Override
  public void end(final boolean interrupted) {
    m_subsystem.rotationspeed (AngleTarget);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}