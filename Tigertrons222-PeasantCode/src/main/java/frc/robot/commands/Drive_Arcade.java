package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive_Arcade extends CommandBase {
  private final Drivetrain m_subsystem;

    public Drive_Arcade(Drivetrain subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  //double moveSpeed = -RobotContainer.Controller.getRawAxis(1);
  //double rotateSpeed = RobotContainer.Controller.getRawAxis(0);

  double rotateSpeed = 0;
  double moveSpeed = 0;
  
  m_subsystem.arcadeDrive(moveSpeed,rotateSpeed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}