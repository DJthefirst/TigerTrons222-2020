package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Autodrive_forward extends CommandBase {
  private final Drivetrain m_subsystem;
  double movespeed;
  double movedistance;

    public Autodrive_forward(double movespeedvalue, double movedistancevalue) {
    m_subsystem = RobotContainer.m_drivetrain;
    addRequirements(m_subsystem);
    movespeed =  movespeedvalue;
    movedistance = movedistancevalue;
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  double moveSpeed = 0;
  if (Math.abs(moveSpeed) < 0.13) {

    // within 10% joystick, make it zero 
  moveSpeed = 0;
  }
  
  m_subsystem.arcadeDrive(moveSpeed, moveSpeed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}