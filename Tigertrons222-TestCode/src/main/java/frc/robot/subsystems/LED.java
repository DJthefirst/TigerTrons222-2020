package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {

    Spark spark = new Spark(0);

public void setLEDcolor (double LED){
    spark.set(LED);
}
}