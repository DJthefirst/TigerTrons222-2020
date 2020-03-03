package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Conveyor extends SubsystemBase {

    CANSparkMax conveyorSparkMax = new CANSparkMax(RobotMap.CONVEYOR_SPARKMAX, MotorType.kBrushless);
    CANEncoder conveyorCANEncoder = new CANEncoder(conveyorSparkMax);
    // DigitalInput SparkEncoderInput = new DigitalInput(0);
    // DutyCycle SparkEncoder = new DutyCycle(SparkEncoderInput);
    private CANPIDController m_conveyorPidController = new CANPIDController(conveyorSparkMax);

    public Conveyor() {

        m_conveyorPidController.setP(Constants.spary_kGains.kP);
        m_conveyorPidController.setI(Constants.spary_kGains.kI);
        m_conveyorPidController.setD(Constants.spary_kGains.kD);
        m_conveyorPidController.setIZone(Constants.spary_kGains.kIzone);
        m_conveyorPidController.setFF(Constants.spary_kGains.kFF);
        m_conveyorPidController.setOutputRange(Constants.spary_kGains.kMinOutput, Constants.spary_kGains.kMaxOutput);
    }

    public Conveyor(int i) {
	}

public void spinSpeed (double turnSpeed)
{
    conveyorSparkMax.set(turnSpeed);
}

public void spinSpeedPID (double SetPointSpeed)
{
    m_conveyorPidController.setReference(SetPointSpeed, ControlType.kVelocity);
}

public void readEncoderAUX (){
    //System.out.println("Get :" + (SparkEncoder.getOutput()*360));

}

    public CANEncoder getDriveEncoder() {
    return conveyorCANEncoder;
}





}