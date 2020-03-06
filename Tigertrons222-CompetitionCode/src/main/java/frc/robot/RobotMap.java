package frc.robot;

public class RobotMap {

	//Sparks
	public static final int DRIVETRAIN_RIGHT_Master_SPARKMAX = 1;
	public static final int DRIVETRAIN_RIGHT_Slave1_SPARKMAX = 2;
	public static final int DRIVETRAIN_RIGHT_Slave2_SPARKMAX = 3;			
	public static final int DRIVETRAIN_LEFT_Master_SPARKMAX = 4;
	public static final int DRIVETRAIN_LEFT_Slave1_SPARKMAX = 5;
	public static final int DRIVETRAIN_LEFT_Slave2_SPARKMAX = 6;

	public static final int INTAKE_SPARKMAX = 7; //15 for practicebot
	public static final int SHOOTER1_SPARKMAX = 8;//13 for practicebot
	public static final int SHOOTER2_SPARKMAX = 10; //14 for practicebot	
	public static final int CONVEYOR_SPARKMAX = 9; //16 for practicebot

	//Talons
	public static final int ROBOT_CLIMB_TALON1 = 11;
	public static final int ROBOT_CLIMB_TALON2 = 12;

	//Digital Inputs

		//Encoders
		public static final int DRIVETRAIN_ENCODER_L = 0;
		public static final int DRIVETRAIN_ENCODER_R = 1;

		//Spark Pwm
		public static final int LED_CONTROLLER = 2;

		//LimitSwitch
		public static final int ARM_LIMITSWITCH = 3;

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

	//Led Color Codes
	public static final double LED_COLOR_PASSIVE = .99;	//black
	public static final double LED_COLOR_AIMING =.61;	//red
	public static final double LED_COLOR_ALIGNED = .73;	//lime
	public static final double LED_COLOR_FIREING = .75;	//Dark green
	
}