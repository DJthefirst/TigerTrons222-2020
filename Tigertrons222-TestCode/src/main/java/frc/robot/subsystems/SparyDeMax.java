package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparyDeMax extends SubsystemBase {

    CANSparkMax SparkyMax = new CANSparkMax(8, MotorType.kBrushless);
    CANEncoder encoder = new CANEncoder(SparkyMax);
    private CANPIDController m_sparypidController = new CANPIDController(SparkyMax);

    


public SparyDeMax(){


    m_sparypidController.setP(Constants.spary_kGains.kP);
    m_sparypidController.setI(Constants.spary_kGains.kI);
    m_sparypidController.setD(Constants.spary_kGains.kD);
    m_sparypidController.setIZone(Constants.spary_kGains.kIzone);
    m_sparypidController.setFF(Constants.spary_kGains.kFF);
    m_sparypidController.setOutputRange(Constants.spary_kGains.kMinOutput, Constants.spary_kGains.kMaxOutput);
}

public void turn (double turnSpeed)
{
    SparkyMax.set(turnSpeed);
}

public void turnPID (double SetPointSpeed)
{
    m_sparypidController.setReference(SetPointSpeed, ControlType.kVelocity);
}

public CANEncoder getDriveEncoder() {
    return encoder;
}





}