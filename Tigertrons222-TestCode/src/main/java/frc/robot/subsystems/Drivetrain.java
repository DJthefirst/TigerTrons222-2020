package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

    CANSparkMax leftMaster1SparkMax = new CANSparkMax(1,MotorType.kBrushless);
    CANSparkMax leftSlave2SparkMax = new CANSparkMax(2,MotorType.kBrushless);
    CANSparkMax leftSlave3SparkMax = new CANSparkMax(3,MotorType.kBrushless);
    CANSparkMax rightMaster1SparkMax = new CANSparkMax(4,MotorType.kBrushless);
    CANSparkMax rightSlave2SparkMax = new CANSparkMax(5,MotorType.kBrushless);
    CANSparkMax rightSlave3SparkMax = new CANSparkMax(6,MotorType.kBrushless);

    DifferentialDrive differentialDrive = new DifferentialDrive(rightMaster1SparkMax,leftMaster1SparkMax);

public Drivetrain()
{
    leftSlave2SparkMax.follow(leftMaster1SparkMax);
    leftSlave3SparkMax.follow(leftMaster1SparkMax);
    rightSlave2SparkMax.follow(rightMaster1SparkMax);
    rightSlave3SparkMax.follow(rightMaster1SparkMax);
}

public void arcadeDrive (double moveSpeed, double rotateSpeed)
{
    differentialDrive.arcadeDrive(moveSpeed,-rotateSpeed);
}
}