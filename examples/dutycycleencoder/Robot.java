/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.dutycycleencoder;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings({"PMD.SingularField"})
public class Robot extends TimedRobot {
  private DutyCycleEncoder m_dutyCycleEncoder;

  @Override
  public void robotInit() {
    m_dutyCycleEncoder = new DutyCycleEncoder(0);

    // Set to 0.5 units per rotation
    m_dutyCycleEncoder.setDistancePerRotation(0.5);
  }

  @Override
  public void robotPeriodic() {
    // Connected can be checked, and uses the frequency of the encoder
    boolean connected = m_dutyCycleEncoder.isConnected();

    // Duty Cycle Frequency in Hz
    int frequency = m_dutyCycleEncoder.getFrequency();

    // Output of encoder
    double output = m_dutyCycleEncoder.get();

    // Output scaled by DistancePerPulse
    double distance = m_dutyCycleEncoder.getDistance();

    SmartDashboard.putBoolean("Connected", connected);
    SmartDashboard.putNumber("Frequency", frequency);
    SmartDashboard.putNumber("Output", output);
    SmartDashboard.putNumber("Distance", distance);
  }

}
