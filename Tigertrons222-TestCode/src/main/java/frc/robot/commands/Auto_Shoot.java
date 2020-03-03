package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.commands.Pnu_UnknownOut;
import frc.robot.commands.Pnu_UnknownIn;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto_Shoot extends CommandBase {
    private final Drivetrain m_subsystem;

    double ShooterRPMTarget = -3500;
    double intakeSpeed;

    public Auto_Shoot() {

    m_subsystem = RobotContainer.m_drivetrain;
  
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    //tilt balls
    //new Pnu_UnknownOut(RobotContainer.m_unknown);
    
  }

  
  @Override
  public void execute() {
    //limelight on and aim

    //get limelight distance to rpm

    //rev up motor
    
    //when motor up to speed shoot
    RobotContainer.m_Shooter.spinSpeedPID(ShooterRPMTarget);

    if (Math.abs(RobotContainer.m_Shooter.getShooterSpeed()) > Math.abs(ShooterRPMTarget*.9)){
      RobotContainer.m_conveyor.spinSpeedPID(Constants.conveyor_speed);
    }
    //else{
        //RobotContainer.m_conveyor.turn(0);
    //}
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_conveyor.turn(0);
    RobotContainer.m_Shooter.spinSpeed(0);

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}