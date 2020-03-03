package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Limelight_Led extends CommandBase {
    NetworkTable table;

    public Limelight_Led() {

    addRequirements(RobotContainer.m_drivetrain);
  }
  
  @Override
  public void initialize() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    table.getEntry("pipeline").setNumber(0);
  }
     
  @Override
  public void execute() {

  }

  @Override
  public void end(final boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return true;
  }
}