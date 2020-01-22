package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class motorsub extends SubsystemBase {

    CANSparkMax mChickyChickyNugNug = new CANSparkMax(1,MotorType.kBrushless);
    // CANSparkMax leftSlave2SparkMax = new CANSparkMax(2,MotorType.kBrushless);
    // CANSparkMax leftSlave3SparkMax = new CANSparkMax(3,MotorType.kBrushless);
    // CANSparkMax rightMaster1SparkMax = new CANSparkMax(4,MotorType.kBrushless);
    // CANSparkMax rightSlave2SparkMax = new CANSparkMax(5,MotorType.kBrushless);
    // CANSparkMax rightSlave3SparkMax = new CANSparkMax(6,MotorType.kBrushless);

{
    // leftSlave2SparkMax.follow(leftMaster1SparkMax);
    // leftSlave3SparkMax.follow(leftMaster1SparkMax);
    // rightSlave2SparkMax.follow(rightMaster1SparkMax);
    // rightSlave3SparkMax.follow(rightMaster1SparkMax);

}

public void motorspinner (double rotateSpeed)
{

	mChickyChickyNugNug.set(rotateSpeed);
}

}