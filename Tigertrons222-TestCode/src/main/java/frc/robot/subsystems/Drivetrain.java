package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
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
    PIDController GyrorotationalController = new PIDController(0,0,0);
    PIDController LimerotationalController = new PIDController(0,0,0);

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
        leftMaster1SparkMax.setOpenLoopRampRate(.1);
        rightMaster1SparkMax.setOpenLoopRampRate(.1);
        //leftSparkMaxPID.setFeedbackDevice(null);
        //rightSparkMaxPID.setFeedbackDevice(null);

        leftSparkMaxPID.setP(Constants.drivetrain_Drive_kGains.kP);
        leftSparkMaxPID.setI(Constants.drivetrain_Drive_kGains.kI);
        leftSparkMaxPID.setD(Constants.drivetrain_Drive_kGains.kD);
        leftSparkMaxPID.setIZone(Constants.drivetrain_Drive_kGains.kI);
        leftSparkMaxPID.setFF(Constants.drivetrain_Drive_kGains.kFF);
        leftSparkMaxPID.setSmartMotionMaxAccel(Constants.drivetrain_kAcc, 0);
        leftSparkMaxPID.setSmartMotionMaxVelocity(Constants.drivetrain_kVel, 0);
        leftSparkMaxPID.setSmartMotionMaxAccel(1000, 0);


        rightSparkMaxPID.setP(Constants.drivetrain_Drive_kGains.kP);
        rightSparkMaxPID.setI(Constants.drivetrain_Drive_kGains.kI);
        rightSparkMaxPID.setD(Constants.drivetrain_Drive_kGains.kD);
        rightSparkMaxPID.setIZone(Constants.drivetrain_Drive_kGains.kI);
        rightSparkMaxPID.setFF(Constants.drivetrain_Drive_kGains.kFF);
        rightSparkMaxPID.setSmartMotionMaxAccel((Constants.drivetrain_kAcc), 0);
        rightSparkMaxPID.setSmartMotionMaxVelocity(Constants.drivetrain_kVel, 0);
        rightSparkMaxPID.setSmartMotionMaxAccel(1000, 0);

        GyrorotationalController.setP(Constants.drivetrain_GyroRotate_kGains.kP);
        GyrorotationalController.setI(Constants.drivetrain_GyroRotate_kGains.kI);
        GyrorotationalController.setD(Constants.drivetrain_GyroRotate_kGains.kD);
        GyrorotationalController.disableContinuousInput();
        GyrorotationalController.setTolerance(.1);
        GyrorotationalController.setIntegratorRange(-.4, .4);

        LimerotationalController.setP(Constants.drivetrain_LimeRotate_kGains.kP);
        LimerotationalController.setI(Constants.drivetrain_LimeRotate_kGains.kI);
        LimerotationalController.setD(Constants.drivetrain_LimeRotate_kGains.kD);
        LimerotationalController.disableContinuousInput();
        LimerotationalController.setTolerance(.1);
        LimerotationalController.setIntegratorRange(-.4, .4);
    }

    //Controls
    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
        differentialDrive.arcadeDrive(-moveSpeed, -rotateSpeed);
    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        differentialDrive.tankDrive(-leftSpeed,-rightSpeed);
    }

    public void PidDrive(double moveposition) {
        leftSparkMaxPID.setReference(moveposition, ControlType.kPosition);
        rightSparkMaxPID.setReference(-moveposition, ControlType.kPosition);
    }

    public double GyroPidRotate(double setPoint, double currentPosition) {
        double speed = GyrorotationalController.calculate(currentPosition,setPoint);
        return speed;
    }

    public double LimePidRotate(double setPoint, double currentPosition) {
        double speed = LimerotationalController.calculate(currentPosition,setPoint);
        return speed;
    }


    //Encoders

    public double leftEncoderCurrentPos(){
        //double currentPositionLeft = dutyCycleDrivetrainEncoderLeft.get()*1000;
        double currentPositionLeft = rightDriveEncoder.getPosition();
        //System.out.println("PWM L:" + leftDriveEncoder.getPosition());
        return currentPositionLeft;
    }

    public double rightEncoderCurrentPos(){
        //double currentPositionRight = dutyCycleDrivetrainEncoderRight.get()*1000; 
        double currentPositionRight = leftDriveEncoder.getPosition();
        //System.out.println("PWM R:" + rightDriveEncoder.getPosition());
        return currentPositionRight;
    }

    public double leftEncoderABSPos(){
        double absposition = (DrivetrainEncoderLeft.getOutput()*360);
        //System.out.println("GetLeft :" + Currentposition);
        return absposition;
    }

    public double rightEncoderABSPos(){
        double absposition = (DrivetrainEncoderRight.getOutput()*360);
        //System.out.println("GetRight :" + Currentposition);
        return absposition;
    }

    public void resetDriveEncoderPos(){
        rightDriveEncoder.setPosition(0);
        leftDriveEncoder.setPosition(0);
    }
}