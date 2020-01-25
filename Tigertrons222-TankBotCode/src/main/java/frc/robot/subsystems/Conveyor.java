package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Conveyor extends SubsystemBase {

    CANSparkMax ConveyorMotor = new CANSparkMax(9, MotorType.kBrushless);
 
    CANEncoder ConveyorCANEncoder = new CANEncoder(ConveyorMotor);
 
    private CANPIDController m_conveyorpidController = new CANPIDController(ConveyorMotor);


    public Conveyor() {
        m_conveyorpidController.setP(Constants.shooter_kGains.kP);
        m_conveyorpidController.setI(Constants.shooter_kGains.kI);
        m_conveyorpidController.setD(Constants.shooter_kGains.kD);
        m_conveyorpidController.setIZone(Constants.shooter_kGains.kIzone);
        m_conveyorpidController.setFF(Constants.shooter_kGains.kFF);
        m_conveyorpidController.setOutputRange(Constants.shooter_kGains.kMinOutput, Constants.shooter_kGains.kMaxOutput);
    }


public void turn (double turnSpeed){
    ConveyorMotor.set(turnSpeed);
}


public void turnPID (double SetPointSpeed){
    m_conveyorpidController.setReference(SetPointSpeed, ControlType.kVelocity);
}


public CANEncoder getConveyorEncoder() {
    return ConveyorCANEncoder;
}
}