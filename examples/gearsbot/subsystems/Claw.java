/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.gearsbot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing. If using stronger
 * motors, you should probably use a sensor so that the motors don't stall.
 */
public class Claw extends SubsystemBase {
  private final Victor m_motor = new Victor(7);
  private final DigitalInput m_contact = new DigitalInput(5);

  /**
   * Create a new claw subsystem.
   */
  public Claw() {
    // Let's name everything on the LiveWindow
    addChild("Motor", m_motor);
    addChild("Limit Switch", m_contact);
  }

  public void log() {
    SmartDashboard.putData("Claw switch", m_contact);
  }

  /**
   * Set the claw motor to move in the open direction.
   */
  public void open() {
    m_motor.set(-1);
  }

  /**
   * Set the claw motor to move in the close direction.
   */
  public void close() {
    m_motor.set(1);
  }

  /**
   * Stops the claw motor from moving.
   */
  public void stop() {
    m_motor.set(0);
  }

  /**
   * Return true when the robot is grabbing an object hard enough to trigger the limit switch.
   */
  public boolean isGrabbing() {
    return m_contact.get();
  }
}
