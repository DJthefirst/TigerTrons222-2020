package frc.robot.commands;

//import edu.wpi.first.networktables.NetworkTable;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LED;
//import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LED_spark extends CommandBase {
    private final LED m_subsystem;

    double color;

    public LED_spark(final double colorVal) {
    color = colorVal;
    m_subsystem = RobotContainer.m_LED;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }
  
  @Override
  public void execute() {
      m_subsystem.setLEDcolor(color);
    }

  @Override
  public void end(final boolean interrupted) {
  }
  
  @Override
  public boolean isFinished() {
    return true;
  }

public void setDefaultCommand(final LED mLed) {
}
}