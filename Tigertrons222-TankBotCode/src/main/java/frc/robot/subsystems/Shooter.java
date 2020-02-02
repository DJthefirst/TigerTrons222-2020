package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    // CANSparkMax leftMaster1SparkMax = new CANSparkMax(1,MotorType.kBrushless);
    // CANSparkMax leftSlave2SparkMax = new CANSparkMax(2,MotorType.kBrushless);
    // CANSparkMax leftSlave3SparkMax = new CANSparkMax(3,MotorType.kBrushless);
    // CANSparkMax rightMaster1SparkMax = new CANSparkMax(4,MotorType.kBrushless);
    // CANSparkMax rightSlave2SparkMax = new CANSparkMax(5,MotorType.kBrushless);
    // CANSparkMax rightSlave3SparkMax = new CANSparkMax(6,MotorType.kBrushless);

    WPI_TalonSRX MasterTalon = new WPI_TalonSRX(9);
 

    public Shooter(){
}


public void Drive (double moveSpeed)
{
    MasterTalon.set(moveSpeed);
}
}

