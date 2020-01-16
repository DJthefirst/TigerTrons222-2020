package frc.robot.subsystems;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    // CANSparkMax leftMaster1SparkMax = new CANSparkMax(1,MotorType.kBrushless);
    // CANSparkMax leftSlave2SparkMax = new CANSparkMax(2,MotorType.kBrushless);
    // CANSparkMax leftSlave3SparkMax = new CANSparkMax(3,MotorType.kBrushless);
    // CANSparkMax rightMaster1SparkMax = new CANSparkMax(4,MotorType.kBrushless);
    // CANSparkMax rightSlave2SparkMax = new CANSparkMax(5,MotorType.kBrushless);
    // CANSparkMax rightSlave3SparkMax = new CANSparkMax(6,MotorType.kBrushless);

    WPI_TalonSRX leftMasterTalon = new WPI_TalonSRX(4);
	WPI_TalonSRX rightMasterTalon = new WPI_TalonSRX(1);
	
	
	WPI_TalonSRX leftSlave1Talon = new WPI_TalonSRX(5);
	WPI_TalonSRX leftSlave2Talon = new WPI_TalonSRX(6);
	WPI_TalonSRX rightSlave1Talon = new WPI_TalonSRX(2);
	WPI_TalonSRX rightSlave2Talon = new WPI_TalonSRX(3);

    DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterTalon,leftMasterTalon);

public Drivetrain()
{
    // leftSlave2SparkMax.follow(leftMaster1SparkMax);
    // leftSlave3SparkMax.follow(leftMaster1SparkMax);
    // rightSlave2SparkMax.follow(rightMaster1SparkMax);
    // rightSlave3SparkMax.follow(rightMaster1SparkMax);

    leftSlave1Talon.follow(leftMasterTalon);
    leftSlave2Talon.follow(leftMasterTalon);
    rightSlave1Talon.follow(rightMasterTalon);
    rightSlave2Talon.follow(rightMasterTalon);
}

public void arcadeDrive (double moveSpeed, double rotateSpeed)
{
    differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}

public void motorsub(double rotateSpeed) {
}
}