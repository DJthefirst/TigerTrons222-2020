package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LED extends SubsystemBase {

    Spark spark = new Spark(RobotMap.LED_CONTROLLER);

public void setLEDcolor (double LED){
    spark.set(LED);
}
}