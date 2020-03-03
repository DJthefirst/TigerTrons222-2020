package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter_SetSpeed extends CommandBase {
  private final Shooter m_subsystem;

  double SpeedPoint;
  double x;
  double x2;
  double x3;
  double x4;
 

  public Shooter_SetSpeed(double Speed) {
    //SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_Shooter;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }
  
  @Override
  public void execute() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    x = SmartDashboard.getNumber("Distance from target",0);
    x4 = x3;
    x3 = x2;
    x2 = x;
    x = (x+x2+x3+x4)/4;
    SpeedPoint= (-0.0000009*Math.pow(x,4) + 0.0041*Math.pow(x,3) - 2.7347*Math.pow(x,2) + 637.66*x - 52852);
    if (SpeedPoint < -4500){
      SpeedPoint = -4500;
    }

    SmartDashboard.putNumber("Shooter speed", SpeedPoint);
    //SpeedPoint = SmartDashboard.getNumber("Shooter Rpm",1000);
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