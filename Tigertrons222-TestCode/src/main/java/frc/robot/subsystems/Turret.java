package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Turret extends SubsystemBase {

    CANSparkMax ShooterMotorLeft = new CANSparkMax(20, MotorType.kBrushless);
    CANSparkMax ShooterMotorRight = new CANSparkMax(21, MotorType.kBrushless);
    CANEncoder ShooterCANEncoderLeft = new CANEncoder(ShooterMotorLeft);
    CANEncoder ShooterCANEncoderRight = new CANEncoder(ShooterMotorRight);
    private CANPIDController m_shooterpidControllerLeft = new CANPIDController(ShooterMotorLeft);
    private CANPIDController m_shooterpidControllerRight = new CANPIDController(ShooterMotorRight);
    WPI_TalonSRX turretRotationTalon = new WPI_TalonSRX(RobotMap.TURRET_ROTATION_TALON);
    DigitalInput TurretEncoderInput = new DigitalInput(RobotMap.TURRET_ENCODER);
    DutyCycle TurretEncoder = new DutyCycle(TurretEncoderInput);

    public Turret() {
    m_shooterpidControllerLeft.setP(Constants.shooter_kGains.kP);
    m_shooterpidControllerLeft.setI(Constants.shooter_kGains.kI);
    m_shooterpidControllerLeft.setD(Constants.shooter_kGains.kD);
    m_shooterpidControllerLeft.setIZone(Constants.shooter_kGains.kIzone);
    m_shooterpidControllerLeft.setFF(Constants.shooter_kGains.kFF);
    m_shooterpidControllerLeft.setOutputRange(Constants.shooter_kGains.kMinOutput, Constants.shooter_kGains.kMaxOutput);

    m_shooterpidControllerRight.setP(Constants.shooter_kGains.kP);
    m_shooterpidControllerRight.setI(Constants.shooter_kGains.kI);
    m_shooterpidControllerRight.setD(Constants.shooter_kGains.kD);
    m_shooterpidControllerRight.setIZone(Constants.shooter_kGains.kIzone);
    m_shooterpidControllerRight.setFF(Constants.shooter_kGains.kFF);
    m_shooterpidControllerRight.setOutputRange(Constants.shooter_kGains.kMinOutput, Constants.shooter_kGains.kMaxOutput);
	
}
public double getEncoder(){
    double Turretposition = TurretEncoder.getOutput()*360;
    System.out.println("Turret Pos: " + Turretposition);
    return Turretposition;
}

public void spinSpeed (double spinSpeed){
    ShooterMotorLeft.set(spinSpeed);
    ShooterMotorRight.set(spinSpeed);

}
public void rotationspeed (double rotationspeed){
    turretRotationTalon.set (rotationspeed);
}

public void spinSpeedPID (double SetPointSpeed){
    m_shooterpidControllerLeft.setReference(-SetPointSpeed, ControlType.kVelocity);
    m_shooterpidControllerRight.setReference(SetPointSpeed, ControlType.kVelocity);
}



public void spinSpeedDoublePID (double SetPointSpeedLeft,double SetPointSpeedRight){
    m_shooterpidControllerLeft.setReference(-SetPointSpeedLeft, ControlType.kVelocity);
    m_shooterpidControllerRight.setReference(SetPointSpeedRight, ControlType.kVelocity);
}


public CANEncoder getShooterEncoderLeft() {
    return ShooterCANEncoderLeft;
}


public CANEncoder getShooterEncoderRight() {
    return ShooterCANEncoderRight;
}

public void turretPID(double targetPos){
turretRotationTalon.set(ControlMode.Velocity, targetPos);
}

}