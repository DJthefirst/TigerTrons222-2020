package frc.robot.commands;

import frc.robot.subsystems.Limelight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Publish_data extends CommandBase {
    private final Limelight m_subsystem;
    double x;
    double y;
    double z;
    double area;
    double distFromTargetArea;
    double distFromTargetTangent;


    public Publish_data(Limelight subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    SmartDashboard.putNumber("Shooter Rpm", 1000);
  }

  
  @Override
  public void execute() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    //read values periodically
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0); 

    distFromTargetArea = 175.36*Math.pow(area,-0.747);
    //distFromTargetTangent = 
    //h1=13.75

    SmartDashboard.putNumber("Distance from target", distFromTargetArea);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
  }

  @Override
  public void end(boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}