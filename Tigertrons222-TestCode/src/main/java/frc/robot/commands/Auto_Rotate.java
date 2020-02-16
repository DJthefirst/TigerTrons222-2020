package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Imu;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto_Rotate extends CommandBase {
    private final Drivetrain m_subsystem;

    double rotatespeed;
    double angle;
    double initalAngle;
    double CurrentAngle;

    public Auto_Rotate(double rotateSpeedVal, double angleVal) {
        rotatespeed = rotateSpeedVal;
        angle = angleVal;
        m_subsystem = RobotContainer.m_drivetrain;
        addRequirements(m_subsystem);
  }
  
@Override
public void initialize() {

    initalAngle = RobotContainer.m_gyro.getangle();
}
  
@Override
public void execute() {
  
    double moveSpeed = 0;

    CurrentAngle = RobotContainer.m_gyro.getangle();
    
    double turn = ((initalAngle + angle) - CurrentAngle)*rotatespeed;






  if (Math.abs(moveSpeed) < 0.13) {
    // within 10% joystick, make it zero 
  moveSpeed = 0;
  }
  if (Math.abs(rotatespeed) < 0.13) {
            // within 10% joystick, make it zero
            rotatespeed = 0;
        }

        m_subsystem.arcadeDrive(moveSpeed, rotatespeed);
  m_subsystem.leftEncoderABSPos();
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}