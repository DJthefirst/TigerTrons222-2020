package frc.robot.commands.autocommands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Autodrive_forward extends CommandBase {
  private final Drivetrain m_subsystem;

  double distance = 1;
  double initalDistance = 0;
  double currentDistance = 0;
  double x = 0;
  double y = 0;

  public Autodrive_forward(double moveSpeedVal, double DistanceVal) {
    distance = DistanceVal;
    //double moveSpeed = moveSpeedVal;
    m_subsystem = RobotContainer.m_drivetrain;
    addRequirements(m_subsystem);
  }
  
@Override
public void initialize() {

    //initalAngle = RobotContainer.m_gyro.getangle();
    RobotContainer.m_drivetrain.resetDriveEncoderPos();
    initalDistance = (m_subsystem.leftEncoderCurrentPos());
    x = distance*Constants.motorRotationInch/Constants.wheelRotationInch;
}
  
@Override
public void execute() {
  currentDistance = (m_subsystem.leftEncoderCurrentPos());
  m_subsystem.PidDrive(x);
  y++;
  System.out.println("flahdbf "+initalDistance + x);
  System.out.println(currentDistance);
  ///m_subsystem.leftEncoderABSPos();
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    //return (Math.abs(currentDistance) > Math.abs(initalDistance + x));
    if(Math.abs(currentDistance) > Math.abs(initalDistance + x)){
      return true;
    }
    else{
      return false;

    }
  }
}
