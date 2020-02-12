package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LED;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LED_spark extends CommandBase {
    private final LED m_subsystem;

    double color;
    double SpeedPoint;

    public LED_spark(final double x) {
    color = x;
    m_subsystem = RobotContainer.m_LED;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
    // NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    // NetworkTableEntry tx = table.getEntry("tx");
    // double x = tx.getDouble(0.0);
    // if (x<5 && x>-5) {
    //   m_subsystem.setLEDcolor(0.62);
    // }
    // else {
      m_subsystem.setLEDcolor(color);
    }
  //  }
  

  @Override
  public void end(final boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }

public void setDefaultCommand(final LED mLed) {
}
}