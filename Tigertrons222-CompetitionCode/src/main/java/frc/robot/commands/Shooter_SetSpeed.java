package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter_SetSpeed extends CommandBase {
  private final Shooter m_subsystem;

  NetworkTable table;
  double SpeedPoint =0;
  double[] previousVal = new double[10];
  double TargDist = 0;
  double x2;
  double x3;
  double x4;
 

  public Shooter_SetSpeed(double Speed) {
    //SpeedPoint = Speed;
    m_subsystem = RobotContainer.m_Shooter;
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    //initalize previous values
    for(int i=0; i<10; i++){
      previousVal[i]=0;
    }

  }
  
  @Override
  public void execute() {
    //shift previous values up one
    for(int i=0; i<9; i++){
      previousVal[i+1]=previousVal[i];
    }

    table = NetworkTableInstance.getDefault().getTable("limelight");
    

    //vefiy limelight is targeting
    if(table.getEntry("pipeline").getDouble(0.0) == 1
    && SmartDashboard.getNumber("Distance from target",180) < 400
    && SmartDashboard.getNumber("Distance from target",180) > 50){
      previousVal[0] = SmartDashboard.getNumber("Distance from target",180);
    }
    else{
      previousVal[0] =180;
    }
    

    //compute average of previous values
    double sum = 0;
    for(int i=0; i<10; i++)sum += previousVal[i];
    TargDist = sum/10;

    SpeedPoint= (-0.0000009*Math.pow(TargDist,4) + 0.0041*Math.pow(TargDist,3) - 2.7347*Math.pow(TargDist,2) + 637.66*TargDist - 52852);
    if (SpeedPoint < -4500){
      SpeedPoint = -4500;
    }

    SmartDashboard.putNumber("Shooter speed", SpeedPoint);
    //SpeedPoint = SmartDashboard.getNumber("Shooter Rpm",1000);
    m_subsystem.spinSpeedPID(SpeedPoint);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.spinSpeed(0);
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}