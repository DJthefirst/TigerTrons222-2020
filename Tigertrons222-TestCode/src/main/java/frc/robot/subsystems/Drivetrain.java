package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {

    // CANSparkMax leftMaster1SparkMax = new CANSparkMax(1,MotorType.kBrushless);
    // CANSparkMax leftSlave2SparkMax = new CANSparkMax(2,MotorType.kBrushless);
    // CANSparkMax leftSlave3SparkMax = new CANSparkMax(3,MotorType.kBrushless);
    // CANSparkMax rightMaster1SparkMax = new CANSparkMax(4,MotorType.kBrushless);
    // CANSparkMax rightSlave2SparkMax = new CANSparkMax(5,MotorType.kBrushless);
    // CANSparkMax rightSlave3SparkMax = new CANSparkMax(6,MotorType.kBrushless);

    DigitalInput DrivetrainEncoderInputLeft = new DigitalInput(RobotMap.DRIVETRAIN_ENCODER_L);
    DutyCycle DrivetrainEncoderLeft = new DutyCycle(DrivetrainEncoderInputLeft);
    DutyCycleEncoder dutyCycleDrivetrainEncoderLeft = new DutyCycleEncoder(DrivetrainEncoderInputLeft);
    DigitalInput DrivetrainEncoderInputRight = new DigitalInput(RobotMap.DRIVETRAIN_ENCODER_R);
    DutyCycle DrivetrainEncoderRight = new DutyCycle(DrivetrainEncoderInputRight);
    DutyCycleEncoder dutyCycleDrivetrainEncoderRight = new DutyCycleEncoder(DrivetrainEncoderInputRight);


    WPI_TalonSRX leftMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Master_SPARKMAX);
	WPI_TalonSRX rightMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Master_SPARKMAX);
	
	
	WPI_TalonSRX leftSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave1_SPARKMAX);
	WPI_TalonSRX leftSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave2_SPARKMAX);
	WPI_TalonSRX rightSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave1_SPARKMAX);
	WPI_TalonSRX rightSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave2_SPARKMAX);

    //DifferentialDrive differentialDrive = new DifferentialDrive(rightMaster1SparkMax,leftMaster1SparkMax);
    DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterTalon,leftMasterTalon);

public Drivetrain()
{
    // leftSlave2SparkMax.follow(leftMaster1SparkMax);
    // leftSlave3SparkMax.follow(leftMaster1SparkMax);
    // rightSlave2SparkMax.follow(rightMaster1SparkMax);
    // rightSlave3SparkMax.follow(rightMaster1SparkMax);

    leftSlave1Talon.follow(leftMasterTalon);
    leftSlave2Talon.follow(leftMasterTalon);
    rightSlave1Talon.follow(rightMasterTalon);
    rightSlave2Talon.follow(rightMasterTalon);
}


public void arcadeDrive (double moveSpeed, double rotateSpeed)
{
    differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}


public void tankDrive(double leftSpeed, double rightSpeed)
{
    differentialDrive.tankDrive(leftSpeed,rightSpeed);
}


public double leftEncoderABSPos()
{
    double absPositionLeft = dutyCycleDrivetrainEncoderLeft.get();
    System.out.println("PWM :" + absPositionLeft);
    return absPositionLeft;
}

public double rightEncoderABSPos()
{
    double absPositionRight = dutyCycleDrivetrainEncoderRight.get();
    System.out.println("PWM :" + absPositionRight);
    return absPositionRight;
}

public double leftEncoderCurrentPos()
{
    double Currentposition = (DrivetrainEncoderLeft.getOutput()*360);
    System.out.println("Get :" + Currentposition);
    return Currentposition;
}

public double rightEncoderCurrentPos()
{
    double Currentposition = (DrivetrainEncoderRight.getOutput()*360);
    System.out.println("Get :" + Currentposition);
    return Currentposition;
}

}