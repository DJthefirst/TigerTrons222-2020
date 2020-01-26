package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CMD_Intake extends CommandBase {
    private final Shooter m_subsystem;

    public CMD_Intake(Shooter subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  double moveSpeed = RobotContainer.Controller.getRawAxis(5);

  
  m_subsystem.Drive(moveSpeed);
  
  }

  @Override
  public void end(boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}