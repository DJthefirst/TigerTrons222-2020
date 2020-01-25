package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterWheels extends SubsystemBase {

    CANSparkMax ShooterMotorLeft = new CANSparkMax(9, MotorType.kBrushless);
    CANSparkMax ShooterMotorRight = new CANSparkMax(10, MotorType.kBrushless);
    CANEncoder ShooterCANEncoderLeft = new CANEncoder(ShooterMotorLeft);
    CANEncoder ShooterCANEncoderRight = new CANEncoder(ShooterMotorRight);
    private CANPIDController m_shooterpidControllerLeft = new CANPIDController(ShooterMotorLeft);
    private CANPIDController m_shooterpidControllerRight = new CANPIDController(ShooterMotorRight);

public ShooterWheels() {
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


public void turn (double spinSpeed){
    ShooterMotorLeft.set(spinSpeed);
}


public void spinSpeedPID (double SetPointSpeedLeft,double SetPointSpeedRight){
    m_shooterpidControllerLeft.setReference(SetPointSpeedLeft, ControlType.kVelocity);
    m_shooterpidControllerRight.setReference(SetPointSpeedRight, ControlType.kVelocity);
}


public CANEncoder getShooterEncoderLeft() {
    return ShooterCANEncoderLeft;
}


public CANEncoder getShooterEncoderRight() {
    return ShooterCANEncoderRight;
}
}