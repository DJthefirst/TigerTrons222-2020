package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparyDeMax extends SubsystemBase {

    CANSparkMax SparkyMax = new CANSparkMax(8, MotorType.kBrushless);
    CANEncoder encoder = new CANEncoder(SparkyMax);
    public SparyDeMax(){
}

public void turn (double turnSpeed)
{
    SparkyMax.set(turnSpeed);
}

public CANEncoder getDriveEncoder() {
    return encoder;
}





}