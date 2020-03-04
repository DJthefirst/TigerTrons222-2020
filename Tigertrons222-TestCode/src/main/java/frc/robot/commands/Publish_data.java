package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Publish_data extends CommandBase {
    private final Limelight m_subsystem;
    NetworkTable table;
    double limeX;
    double limeY;
    double limeZ;
    double limeArea;
    double distFromTargetArea;
    double distFromTargetTangent;


    public Publish_data(Limelight subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    SmartDashboard.putNumber("Shooter Rpm", 1000);
  }

  
  @Override
  public void execute() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    //read values periodically
    limeX = tx.getDouble(0.0);
    limeY = ty.getDouble(0.0);
    limeArea = ta.getDouble(0.0); 

    distFromTargetArea = 175.36*Math.pow(limeArea,-0.747);
    //distFromTargetTangent = 
    //h1=13.75

    SmartDashboard.putNumber("Distance from target", distFromTargetArea);
    SmartDashboard.putNumber("LimelightX", limeX);
    SmartDashboard.putNumber("LimelightY", limeY);
    SmartDashboard.putNumber("LimelightArea", limeArea);
    SmartDashboard.putNumber("GyroX",RobotContainer.m_gyro.getx());
    SmartDashboard.putNumber("GyroY",RobotContainer.m_gyro.gety());
  }

  @Override
  public void end(boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}