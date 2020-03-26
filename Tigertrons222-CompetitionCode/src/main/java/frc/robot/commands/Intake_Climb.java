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


public class Intake_Climb extends CommandBase {
  private final Intake m_subsystem;
  double climbSpeed;
  public Intake_Climb() {
      m_subsystem = RobotContainer.m_arm;
    
      addRequirements(m_subsystem);
    }
      
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Clmib Speed",0);
    }
    
      
  @Override
  public void execute() {
    climbSpeed =RobotContainer.Controller2.getRawAxis(1);

    m_subsystem.Drive(climbSpeed);

  }
  @Override
  public void end(boolean interrupted) {
    m_subsystem.Drive(0);
  }
    
      
  @Override
  public boolean isFinished() {
    return false;
  }
}