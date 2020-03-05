package frc.robot.commands.autocommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto_Rotate extends CommandBase {
  private final Drivetrain m_subsystem;

  double targetAngle;
  double initalAngle;
  double angle;
  double end =100;

  public Auto_Rotate(double moveSpeedVal, double angleVal) {
    targetAngle = angleVal;
    //double moveSpeed = moveSpeedVal;
    m_subsystem = RobotContainer.m_drivetrain;
    addRequirements(m_subsystem);
  }
  
@Override
public void initialize() {
  RobotContainer.m_gyro.m_reset();
  initalAngle = RobotContainer.m_gyro.getangle();
  //RobotContainer.m_drivetrain.resetDriveEncoderPos();

}
  
@Override
public void execute() {

  angle = RobotContainer.m_gyro.getangle();
  double x = m_subsystem.GyroPidRotate(initalAngle + targetAngle, angle);
  //System.out.println("Target :"+targetAngle+", Current :"+angle+", Speed :"+x);

  m_subsystem.tankDrive(x, -x);

  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    end = (end/1.09) + Math.abs((Math.abs(targetAngle + initalAngle) - Math.abs(angle)));
    //System.out.println("E "+end);
    //System.out.println("I "+initalAngle);
    //System.out.println("A "+angle);
    return (end < 1);
  }
}