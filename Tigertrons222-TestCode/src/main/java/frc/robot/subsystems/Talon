package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;;


public class Conveyor extends SubsystemBase {

    private Talon ConveyorMotor = new Talon(RobotMap.CONVEYOR_MOTOR_TALON);

    public Conveyor() {

    }

    public void turn (){
        ConveyorMotor.set(Constants.conveyor_speed);
    }
}