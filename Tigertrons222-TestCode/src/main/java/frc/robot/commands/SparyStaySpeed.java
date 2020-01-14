package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.SparyDeMax;
import com.revrobotics.CANPIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparyStaySpeed extends CommandBase {
    private final SparyDeMax m_subsystem;

    public SparyStaySpeed(SparyDeMax subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }
  double point = 600;
  
  @Override
  public void execute() {

  m_subsystem.turnPID(point);
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