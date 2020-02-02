package frc.robot;

public class RobotMap {

	//Sparks
	public static final int DRIVETRAIN_RIGHT_Master_SPARKMAX = 1;
	public static final int DRIVETRAIN_RIGHT_Slave1_SPARKMAX = 2;
	public static final int DRIVETRAIN_RIGHT_Slave2_SPARKMAX = 3;			
	public static final int DRIVETRAIN_LEFT_Master_SPARKMAX = 4;
	public static final int DRIVETRAIN_LEFT_Slave1_SPARKMAX = 5;
	public static final int DRIVETRAIN_LEFT_Slave2_SPARKMAX = 6;

	//Talons
	public static final int ARM_MOTOR_Master_TALON = 8;
	public static final int ARM_MOTOR_Slave_TALON = 9;
	public static final int Climb_MOTOR_Master_TALON = 7;
	public static final int Climb_MOTOR_Slave_TALON = 10;
	public static final int Intake_MOTOR_TALON = 12;

	//Spikes

	//Encoders
	public static final int DRIVETRAIN_ENCODER_L = 0;
	public static final int DRIVETRAIN_ENCODER_R = 1;
  	public static final int ARM_ENCODER = 2;

	//Gyro

	//Controllers
	public static final int XBOX_DRIVER_CONTROLLER1 = 0;
	public static final int XBOX_DRIVER_CONTROLLER2 = 1;
	
	//Joysticks
	public static final int DRIVER_CONTROLLER2_FOWARD_AXIS = 1;
	public static final int DRIVER_CONTROLLER2_ROTATE_AXIS = 2;

  	//Solenoids
  	public static final int SHIFT_SOLENOID_MODULE = 0;
	public static final int SHIFT_SOLENOID_DEPLOY = 0;
  	public static final int SHIFT_SOLENOID_RETRACT = 1;
  	public static final int UNKNOWN1_SOLENOID_MODULE = 0;
	public static final int UNKNOWN1_SOLENOID_DEPLOY = 2;
  	public static final int UNKNOWN1_SOLENOID_RETRACT = 3;
  	public static final int UNKNOWN2_SOLENOID_MODULE = 0;
	public static final int UNKNOWN2_SOLENOID_DEPLOY =5;
  	public static final int UNKNOWN2_SOLENOID_RETRACT = 4;
  	public static final int UNKNOWN3_SOLENOID_MODULE = 0;
	public static final int UNKNOWN3_SOLENOID_DEPLOY = 6;
	public static final int UNKNOWN3_SOLENOID_RETRACT = 7;
}