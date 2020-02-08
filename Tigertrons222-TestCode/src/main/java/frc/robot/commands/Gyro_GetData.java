package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Imu;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Gyro_GetData extends CommandBase {
    private final Imu m_subsystem;

    public Gyro_GetData(Imu subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    //double x = RobotContainer.m_drivetrain.rightEncoderCurrentPos();
    //m_subsystem.getx();
    //m_subsystem.gety(); 
    //m_subsystem.getraw();   
    RobotContainer.m_drivetrain.rightEncoderCurrentPos();
    RobotContainer.m_drivetrain.leftEncoderCurrentPos();                   
  
  }

  @Override
  public void end(boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}