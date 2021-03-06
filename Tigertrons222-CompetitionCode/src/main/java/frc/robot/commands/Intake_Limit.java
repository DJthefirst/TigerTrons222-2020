package frc.robot.commands;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.subsystems.Intake;


public class Intake_Limit extends CommandBase {
  private final Intake m_subsystem;
  NetworkTable table;

  public Intake_Limit(Intake subsystem) {
      m_subsystem = subsystem;
    
      addRequirements(m_subsystem);
    }
      
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Clmib Speed",.5);
    }
    
      
  @Override
  public void execute() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    if (m_subsystem.GetIntakeLimit()) // If the forward limit switch is pressed, we want to keep the values between -1 and 0
      m_subsystem.Drive(SmartDashboard.getNumber("Clmib Speed",10));
    else{
      m_subsystem.Drive(0);
    }

  }
  @Override
  public void end(boolean interrupted) {
  }
    
      
  @Override
  public boolean isFinished() {
    return false;
  }
}