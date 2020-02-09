/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants { 

  //PID Talon
  public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 30;

  //PIDs
  public static final Gains spary_kGains = new Gains(5e-5, 1e-6, 0, 0, 0, -1, 1, 4200);
  public static final Gains shooter_kGains = new Gains(4e-4, 0, 3e-3, 0, 0, -1, 1, 4200);
  public static final Gains conveyor_kGains = new Gains(5e-5, 1e-6, 0, 0, 0, -1, 1, 4200);
  public static final Gains turret_kGains = new Gains(1, 0.001, 5, 0, 0, 0, 1.0, 0);

  //Constant Speeds
  public static final double conveyor_speed = 0.85;
  public static final double turretAngleError = 2;
}
