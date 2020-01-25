// package frc.robot.commands;

// import frc.robot.RobotContainer;
// import frc.robot.subsystems.Drivetrain;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class Drive_Auto extends CommandBase {
//   private final Drivetrain m_subsystem;

//     public Drive_Auto(Drivetrain subsystem,double fowardDistance,double fowardSpeed,double TurnAngle,double TurnSpeed) {
//     m_subsystem = subsystem;

//     addRequirements(RobotContainer.m_drivetrain);
//   }
  
//   @Override
//   public void initialize() {
//   }

  
//   @Override
//   public void execute() {
  
//     requires(Robot.m_drivetrain);
//     driveDistance = inches*(Settings.HatchToBall);
//     driveSpeed = drivespeed;
//     angle = turnangle;
//     turnSpeed = d;
  
//   m_subsystem.arcadeDrive(moveSpeed,turnspee);
//   }turnspee

//   @Override
//   public void end(boolean interrupted) {
//   }

  
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }