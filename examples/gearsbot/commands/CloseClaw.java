/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.gearsbot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.examples.gearsbot.Robot;
import edu.wpi.first.wpilibj.examples.gearsbot.subsystems.Claw;

/**
 * Closes the claw for one second. Real robots should use sensors, stalling motors is BAD!
 */
public class CloseClaw extends CommandBase {
  private final Claw m_claw;

  public CloseClaw(Claw claw) {
    m_claw = claw;
    addRequirements(m_claw);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_claw.close();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_claw.isGrabbing();
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // NOTE: Doesn't stop in simulation due to lower friction causing the
    // can to fall out
    // + there is no need to worry about stalling the motor or crushing the
    // can.
    if (!Robot.isSimulation()) {
      m_claw.stop();
    }
  }
}
