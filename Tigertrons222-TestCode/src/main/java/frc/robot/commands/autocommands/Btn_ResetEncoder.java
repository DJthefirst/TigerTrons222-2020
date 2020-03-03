package frc.robot.commands.autocommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Btn_ResetEncoder extends CommandBase {
  private final Drivetrain m_subsystem = RobotContainer.m_drivetrain;

  @Override
public void initialize() {

m_subsystem.resetDriveEncoderPos();
}
  
@Override
public void execute() {

  RobotContainer.m_drivetrain.resetDriveEncoderPos();

  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}