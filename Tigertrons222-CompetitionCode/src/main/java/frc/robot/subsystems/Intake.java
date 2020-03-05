package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {

    CANSparkMax IntakeSparkMax = new CANSparkMax(RobotMap.INTAKE_SPARKMAX, MotorType.kBrushless);
    CANEncoder IntakeCANEncoder = new CANEncoder(IntakeSparkMax);
    // DigitalInput SparkEncoderInput = new DigitalInput(0);
    // DutyCycle SparkEncoder = new DutyCycle(SparkEncoderInput);
    private CANPIDController m_intakePidController = new CANPIDController(IntakeSparkMax);

    public Intake() {

        m_intakePidController.setP(Constants.spary_kGains.kP);
        m_intakePidController.setI(Constants.spary_kGains.kI);
        m_intakePidController.setD(Constants.spary_kGains.kD);
        m_intakePidController.setIZone(Constants.spary_kGains.kIzone);
        m_intakePidController.setFF(Constants.spary_kGains.kFF);
        m_intakePidController.setOutputRange(Constants.spary_kGains.kMinOutput, Constants.spary_kGains.kMaxOutput);
    }

    public Intake(int i) {
	}

public void spinSpeed (double turnSpeed)
{
    IntakeSparkMax.set(turnSpeed);
}

public void spinSpeedPID (double SetPointSpeed)
{
    m_intakePidController.setReference(SetPointSpeed, ControlType.kVelocity);
}

public void readEncoderAUX (){
    //System.out.println("Get :" + (SparkEncoder.getOutput()*360));

}

    public CANEncoder getDriveEncoder() {
    return IntakeCANEncoder;
}





}