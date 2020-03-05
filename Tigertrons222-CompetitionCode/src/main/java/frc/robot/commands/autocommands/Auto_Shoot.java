package frc.robot.commands.autocommands;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto_Shoot extends CommandBase {
    private final Drivetrain m_subsystem;

    double ShooterRPMTarget;
    double intakeSpeed;

    public Auto_Shoot(double targetShooter) {
      ShooterRPMTarget =targetShooter;
      m_subsystem = RobotContainer.m_drivetrain;
  
    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {

  }
  
  @Override
  public void execute() {

    RobotContainer.m_Shooter.spinSpeedPID(ShooterRPMTarget);

    if (Math.abs(RobotContainer.m_Shooter.getShooterSpeed()) > Math.abs(ShooterRPMTarget*.9)){
      RobotContainer.m_conveyor.spinSpeedPID(Constants.conveyor_speed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_conveyor.spinSpeed(0);
    RobotContainer.m_Shooter.spinSpeed(0);

  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}