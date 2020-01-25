/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

/**
 * A hatch mechanism actuated by a single {@link DoubleSolenoid}.
 */
public class PnuShiftSubsystem extends SubsystemBase {
  private final DoubleSolenoid m_shiftSolenoid = new DoubleSolenoid(RobotMap.SHIFT_SOLENOID_MODULE, RobotMap.SHIFT_SOLENOID_DEPLOY, RobotMap.SHIFT_SOLENOID_RETRACT);

  /**
   * Grabs the hatch.
   */
  public void deploySolenoid() {
    m_shiftSolenoid.set(kForward);
  }

  /**
   * Releases the hatch.
   */
  public void retractSolenoid() {
    m_shiftSolenoid.set(kReverse);
  }
}