package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive_PathFinder extends CommandBase {
  
  Waypoint[] points = new Waypoint[] {
    new Waypoint(0, 0, Pathfinder.d2r(0)),
    new Waypoint(10, 0, 0)
  };

  double wheel_diameter = .5; //In Meters 0.1524
  double ticksPerRevolution = 1000; //Encoder Ticks Per Revolution
  double _maxVelocity = 6.5; //Default 6.5
  double _maxAcceleration = 6.5; //Default 2.0
  double _maxJerk = 10; //Default 60
  double wheelbase_width = 2;
  double leftspeed = 0;
  double rightspeed = 0;

  Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, _maxVelocity, _maxAcceleration, _maxJerk);
  Trajectory trajectory = Pathfinder.generate(points, config);
  TankModifier modifier = new TankModifier(trajectory).modify(wheelbase_width);
    
  EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
  EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());

  private final Drivetrain m_subsystem;
    public Drive_PathFinder(Drivetrain subsystem) {
      m_subsystem = subsystem;
      addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    left.reset();
    right.reset();
		left.configureEncoder((int) RobotContainer.m_drivetrain.leftEncoderCurrentPos(), (int) Math.round(ticksPerRevolution), wheel_diameter); //Configure the encoder
		left.configurePIDVA(1.0, 0.0, 0.0, 1 / _maxVelocity, 0); //Configure the pidva
		right.configureEncoder((int)RobotContainer.m_drivetrain.rightEncoderCurrentPos(), (int) Math.round(ticksPerRevolution), wheel_diameter);
    right.configurePIDVA(1.0, 0.0, 0.0, 1 / _maxVelocity, 0);
    
  }

     
  @Override
  public void execute() {
    //if (!left.isFinished()) {
			//Calculate using the new encoder values
			double l = left.calculate((int) RobotContainer.m_drivetrain.leftEncoderCurrentPos());
			double r = right.calculate((int) RobotContainer.m_drivetrain.rightEncoderCurrentPos());
	
			//Calculate turning
			double gyro_heading = RobotContainer.m_gyro.getangle();
      double desired_heading = Pathfinder.r2d(left.getHeading());
      //double angleDifference = Pathfinder.boundHalfDegrees(desired_heading + gyro_heading);
			double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
			double turn = 0.8 * (-1.0/80.0) * angleDifference;
			
			//System.out.println("Left: " +  (l + turn) + ", Right: " + (r - turn) + " Angle: " + Gyro.getAngle() + "");

      double leftspeed = (l + turn);
      double rightspeed = (r - turn);
    //} 
    //else {
			//Make sure the robot is stopped at the end
      //double leftspeed = 0;
      //double rightspeed= 0;
  
    //}
    m_subsystem.tankDrive(leftspeed,rightspeed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}