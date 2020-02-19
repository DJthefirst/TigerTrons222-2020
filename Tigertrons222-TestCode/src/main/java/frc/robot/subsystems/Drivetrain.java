package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {

    CANSparkMax leftMaster1SparkMax = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax leftSlave2SparkMax = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax leftSlave3SparkMax = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax rightMaster1SparkMax = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax rightSlave2SparkMax = new CANSparkMax(5, MotorType.kBrushless);
    CANSparkMax rightSlave3SparkMax = new CANSparkMax(6, MotorType.kBrushless);
    CANPIDController leftSparkMaxPID = new CANPIDController(leftMaster1SparkMax);
    CANPIDController rightSparkMaxPID = new CANPIDController(rightMaster1SparkMax);

    CANEncoder rightDriveEncoder = new CANEncoder(rightMaster1SparkMax);
    CANEncoder leftDriveEncoder = new CANEncoder(leftMaster1SparkMax);

    DigitalInput DrivetrainEncoderInputLeft = new DigitalInput(RobotMap.DRIVETRAIN_ENCODER_L);
    DutyCycle DrivetrainEncoderLeft = new DutyCycle(DrivetrainEncoderInputLeft);
    DutyCycleEncoder dutyCycleDrivetrainEncoderLeft = new DutyCycleEncoder(DrivetrainEncoderInputLeft);
    DigitalInput DrivetrainEncoderInputRight = new DigitalInput(RobotMap.DRIVETRAIN_ENCODER_R);
    DutyCycle DrivetrainEncoderRight = new DutyCycle(DrivetrainEncoderInputRight);
    DutyCycleEncoder dutyCycleDrivetrainEncoderRight = new DutyCycleEncoder(DrivetrainEncoderInputRight);

    DifferentialDrive differentialDrive = new DifferentialDrive(rightMaster1SparkMax, leftMaster1SparkMax);

    public Drivetrain() {
        leftSlave2SparkMax.follow(leftMaster1SparkMax);
        leftSlave3SparkMax.follow(leftMaster1SparkMax);
        rightSlave2SparkMax.follow(rightMaster1SparkMax);
        rightSlave3SparkMax.follow(rightMaster1SparkMax);

        //leftSparkMaxPID.setFeedbackDevice(null);
        //rightSparkMaxPID.setFeedbackDevice(null);

        leftSparkMaxPID.setP(Constants.drivetrain_kGains.kP);
        leftSparkMaxPID.setI(Constants.drivetrain_kGains.kI);
        leftSparkMaxPID.setD(Constants.drivetrain_kGains.kD);
        leftSparkMaxPID.setIZone(Constants.drivetrain_kGains.kI);
        leftSparkMaxPID.setFF(Constants.drivetrain_kGains.kFF);
        leftSparkMaxPID.setSmartMotionMaxAccel(Constants.drivetrain_kAcc, 0);
        leftSparkMaxPID.setSmartMotionMaxVelocity(Constants.drivetrain_kVel, 0);

        rightSparkMaxPID.setP(Constants.drivetrain_kGains.kP);
        rightSparkMaxPID.setI(Constants.drivetrain_kGains.kI);
        rightSparkMaxPID.setD(Constants.drivetrain_kGains.kD);
        rightSparkMaxPID.setIZone(Constants.drivetrain_kGains.kI);
        rightSparkMaxPID.setFF(Constants.drivetrain_kGains.kFF);
        rightSparkMaxPID.setSmartMotionMaxAccel((Constants.drivetrain_kAcc), 0);
        rightSparkMaxPID.setSmartMotionMaxVelocity(Constants.drivetrain_kVel, 0);
    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
        differentialDrive.arcadeDrive(-moveSpeed, -rotateSpeed);
    }

    public void PidDrive(double moveposition) {
    leftSparkMaxPID.setReference(moveposition, ControlType.kPosition);
    rightSparkMaxPID.setReference(-moveposition, ControlType.kPosition);

}

public void tankDrive(double leftSpeed, double rightSpeed)
{
    differentialDrive.tankDrive(-leftSpeed,-rightSpeed);
}


public double leftEncoderCurrentPos()
{
    double currentPositionLeft = dutyCycleDrivetrainEncoderLeft.get()*1000;
    //System.out.println("PWM L:" + currentPositionLeft);
    return currentPositionLeft;
}

public double rightEncoderCurrentPos()
{
    double currentPositionRight = dutyCycleDrivetrainEncoderRight.get()*1000;
    //System.out.println("PWM R:" + currentPositionRight);
    return currentPositionRight;
}

public double leftEncoderABSPos()
{
    double absposition = (DrivetrainEncoderLeft.getOutput()*360);
    //System.out.println("GetLeft :" + Currentposition);
    return absposition;
}

public void resetDriveEncoderPos()
{
    rightDriveEncoder.setPosition(0);
    leftDriveEncoder.setPosition(0);
}



public double rightEncoderABSPos()
{
    double absposition = (DrivetrainEncoderRight.getOutput()*360);
    //System.out.println("GetRight :" + Currentposition);
    return absposition;
}

}