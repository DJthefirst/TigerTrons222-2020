package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class Imu extends SubsystemBase {

  private ADIS16448_IMU m_imu = new ADIS16448_IMU();

  public Imu() {

    }

  // Set IMU settings
  public void configCal(){
    m_imu.configCalTime(8);  
  }

  public void m_reset() {
    m_imu.reset();
  }

  public void runCal() {
    m_imu.calibrate();
  }

  public double getangle() {
    double angle = m_imu.getAngle();
    return angle; 
    //System.out.println("RAW : "+ raw);
  }

  public double getx() {
    double x = m_imu.getXComplementaryAngle();
    return x;
    //System.out.println("X : "+ x);
  }

  public double gety() {
    double y = m_imu.getYComplementaryAngle();
    return y;
    //System.out.println("Y : "+ y);
  }
}




    
