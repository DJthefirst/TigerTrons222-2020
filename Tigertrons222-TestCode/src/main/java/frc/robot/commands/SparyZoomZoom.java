package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SparyDeMax;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparyZoomZoom extends CommandBase {
    private final SparyDeMax m_subsystem;

    public SparyZoomZoom(SparyDeMax subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  double turnSpeed = RobotContainer.Controller.getRawAxis(3);
  
  m_subsystem.turn(turnSpeed);
  System.out.println(m_subsystem.getDriveEncoder().getVelocity());
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}