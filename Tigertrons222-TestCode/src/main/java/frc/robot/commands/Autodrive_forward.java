package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Autodrive_forward extends CommandBase {
  private final Drivetrain m_subsystem;

  double distance;
  double initalDistance;
  double x;

  public Autodrive_forward(double moveSpeedVal, double DistanceVal) {
    distance = DistanceVal;
    double moveSpeed = moveSpeedVal;
    m_subsystem = RobotContainer.m_drivetrain;
    addRequirements(m_subsystem);
  }
  
@Override
public void initialize() {

    //initalAngle = RobotContainer.m_gyro.getangle();
    RobotContainer.m_drivetrain.resetDriveEncoderPos();
    initalDistance = RobotContainer.m_gyro.getangle();
    x = distance*Constants.motorRotationInch/Constants.wheelRotationInch;
}
  
@Override
public void execute() {

  m_subsystem.PidDrive(x);
  ///m_subsystem.leftEncoderABSPos();
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return ( Math.abs(x) > Math.abs(distance));
  }
}