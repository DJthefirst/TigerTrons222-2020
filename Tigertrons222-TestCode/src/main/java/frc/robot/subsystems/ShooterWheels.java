package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterWheels extends SubsystemBase {

    CANSparkMax ShooterMotor = new CANSparkMax(8, MotorType.kBrushless);
    CANEncoder ShooterCANEncoder = new CANEncoder(ShooterMotor);
    private CANPIDController m_shooterpidController = new CANPIDController(ShooterMotor);

public ShooterWheels() {
    m_shooterpidController.setP(Constants.shooter_kGains.kP);
    m_shooterpidController.setI(Constants.shooter_kGains.kI);
    m_shooterpidController.setD(Constants.shooter_kGains.kD);
    m_shooterpidController.setIZone(Constants.shooter_kGains.kIzone);
    m_shooterpidController.setFF(Constants.shooter_kGains.kFF);
    m_shooterpidController.setOutputRange(Constants.shooter_kGains.kMinOutput, Constants.shooter_kGains.kMaxOutput);
}


public void turn (double turnSpeed)
{
    ShooterMotor.set(turnSpeed);
}


public void turnPID (double SetPointSpeed)
{
    m_shooterpidController.setReference(SetPointSpeed, ControlType.kVelocity);
}


public CANEncoder getDriveEncoder() {
    return ShooterCANEncoder;
}





}