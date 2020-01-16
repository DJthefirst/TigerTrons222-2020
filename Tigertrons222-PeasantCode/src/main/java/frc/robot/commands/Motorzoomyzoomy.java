package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.motorsub;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Motorzoomyzoomy extends CommandBase {
  private final motorsub m_subsystem;

    public Motorzoomyzoomy(final motorsub subsystem) {
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

  final double rotateSpeed = 0.2;
  
  m_subsystem.motorspinner(rotateSpeed);
  
  }
  @Override
  public void end(final boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}