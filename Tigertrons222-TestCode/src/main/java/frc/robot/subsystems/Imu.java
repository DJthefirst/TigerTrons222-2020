package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class Imu extends SubsystemBase {

  private ADIS16448_IMU m_imu = new ADIS16448_IMU();

  public Imu() {

    }

  // Set IMU settings
  //imu = gyro
  public void configCal(){
    m_imu.configCalTime(8);  
  }

  public void m_reset() {
    //m_imu.reset();
  }

  public void runCal() {
    m_imu.calibrate();
  }

  public double getangle() {
    double angle = m_imu.getAngle();
    //System.out.println("RAW : " + m_imu.getAngle());
    return angle; 
  }

  public double getx() {
    double x = m_imu.getXComplementaryAngle();
    System.out.println("X : "+ x);
    return x;
    //System.out.println("X : "+ x);
  }

  public double gety() {
    double y = m_imu.getYComplementaryAngle();
    System.out.println("Y : "+ y);
    return y;
    //System.out.println("Y : "+ y);
  }
}




    
