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
    private final Drivetrain m_subsystem;

    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);

    int encoder_position_inital_left;
    int encoder_position_inital_right;
    double wheel_diameter;
    double max_velocity;
    int encoder_position_left;
    int encoder_position_right;
    double angleDiff;

    Waypoint[] points = new Waypoint[] {
        new Waypoint(0, 0, Pathfinder.d2r(0)),
        new Waypoint(.5, 0, 0)
    };
    Trajectory trajectory = Pathfinder.generate(points, config);
    TankModifier modifier = new TankModifier(trajectory).modify(0.5);

    
    public Drive_PathFinder(Drivetrain subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    
    int encoder_position_inital_left = (int) RobotContainer.m_drivetrain.leftEncoderCurrentPos();
    int encoder_position_inital_right = (int) RobotContainer.m_drivetrain.rightEncoderCurrentPos();
    double wheel_diameter = 0.1524; //6 in
    double max_velocity = .1; //max 13.75 ft/s current 8ft/s //2.4384
    double angleDiff = 0;

  }

  
  @Override
  public void execute() {

    int encoder_position_left = (int) RobotContainer.m_drivetrain.leftEncoderCurrentPos();
    int encoder_position_right =(int) RobotContainer.m_drivetrain.rightEncoderCurrentPos();
  
    EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
    EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
    
    left.configureEncoder(encoder_position_inital_left, 1000, wheel_diameter);
    left.configurePIDVA(1.0, 0.0, 0.0, 1 / max_velocity, 0);

    right.configureEncoder(encoder_position_inital_right, 1000, wheel_diameter);
    right.configurePIDVA(1.0, 0.0, 0.0, 1 / max_velocity, 0);

    double l = left.calculate(encoder_position_left);
    double r = right.calculate(encoder_position_right);

    double gyro_heading = 0;//... your gyro code here ...    // Assuming the gyro is giving a value in degrees
    double desired_heading = Pathfinder.r2d(left.getHeading());  // Should also be in degrees


    // This allows the angle difference to respect 'wrapping', where 360 and 0 are the same value
    double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    angleDifference = angleDifference % 360.0;
    if (Math.abs(angleDifference) > 180.0) {
        angleDiff = (angleDifference > 0) ? angleDifference - 360 : angleDiff + 360;
    } 

    double turn = 0.8 * (-1.0/80.0) * angleDifference;

    double leftspeed = (l + turn);
    double rightspeed = (r - turn);
  
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