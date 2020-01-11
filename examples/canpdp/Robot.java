/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.canpdp;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a sample program showing how to retrieve information from the Power Distribution Panel
 * via CAN. The information will be displayed under variables through the SmartDashboard.
 */
public class Robot extends TimedRobot {
  private static final int kPDPId = 0;

  private final PowerDistributionPanel m_pdp = new PowerDistributionPanel(kPDPId);

  @Override
  public void robotPeriodic() {
    /*
     * Get the current going through channel 7, in Amperes. The PDP returns the
     * current in increments of 0.125A. At low currents
     * the current readings tend to be less accurate.
     */
    SmartDashboard.putNumber("Current Channel 7", m_pdp.getCurrent(7));

    /*
     * Get the voltage going into the PDP, in Volts.
     * The PDP returns the voltage in increments of 0.05 Volts.
     */
    SmartDashboard.putNumber("Voltage", m_pdp.getVoltage());

    /*
     * Retrieves the temperature of the PDP, in degrees Celsius.
     */
    SmartDashboard.putNumber("Temperature", m_pdp.getTemperature());
  }
}
