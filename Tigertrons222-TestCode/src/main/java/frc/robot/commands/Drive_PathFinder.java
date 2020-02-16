package frc.robot.commands;

import frc.robot.RobotContainer;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.io.File;
import java.io.IOException;

public class Drive_PathFinder extends CommandBase{

  //Waypoint[] points = new Waypoint[] { new Waypoint(0, 0, Pathfinder.d2r(0)), new Waypoint(10, 0, 0) };

  double wheel_diameter = .5; // In Meters 0.1524
  double ticksPerRevolution = 1000; // Encoder Ticks Per Revolution
  double _maxVelocity = 6.5; // Default 6.5
  // double _maxAcceleration = 6.5; //Default 2.0
  // double _maxJerk = 10; //Default 60
  // double wheelbase_width = 2;

  Trajectory Ltrajectory;
  Trajectory Rtrajectory;
  EncoderFollower left;
  EncoderFollower right;

  // Trajectory.Config config = new
  // Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
  // Trajectory.Config.SAMPLES_HIGH, 0.05, _maxVelocity, _maxAcceleration,
  // _maxJerk);
  // Trajectory trajectory = Pathfinder.generate(points, config);

  //public Drive_PathFinder(File leftCSV, File rightCSV) throws IOException {
  public Drive_PathFinder(){

    File LFile = new File("/home/lvuser/MotionProfiles/Path2Left.csv");
    File RFile = new File("/home/lvuser/MotionProfiles/Path2Right.csv");


      try {
      Ltrajectory = Pathfinder.readFromCSV(LFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
      try {
      Rtrajectory = Pathfinder.readFromCSV(RFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    addRequirements(RobotContainer.m_drivetrain);
  }
  
  @Override
  public void initialize() {
    EncoderFollower left = new EncoderFollower(Ltrajectory);
    EncoderFollower right = new EncoderFollower(Rtrajectory);
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

    // Calculate turning
    double gyro_heading = RobotContainer.m_gyro.getangle();
    double desired_heading = Pathfinder.r2d(left.getHeading());
    // double angleDifference = Pathfinder.boundHalfDegrees(desired_heading +
    // gyro_heading);
    double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    double turn = 0.8 * (-1.0 / 80.0) * angleDifference;

    // System.out.println("Left: " + (l + turn) + ", Right: " + (r - turn) + "
    // Angle: " + Gyro.getAngle() + "");

    double leftspeed = (l + turn);
    double rightspeed = (r - turn);
    // }
    // else {
    // Make sure the robot is stopped at the end
    // double leftspeed = 0;
    // double rightspeed= 0;

    // }
    RobotContainer.m_drivetrain.tankDrive(leftspeed, rightspeed);
  }

  @Override
  public void end(final boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}