/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive_Arcade;
import frc.robot.commands.SparyZoomZoom;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SparyDeMax;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final SparyDeMax m_spark = new SparyDeMax();

  private final Drive_Arcade m_drive_arcade = new Drive_Arcade(m_drivetrain);
  private final SparyZoomZoom m_drive_sparky = new SparyZoomZoom(m_spark);

  public static final XboxController Controller = new XboxController(0);
	public static final XboxController Controller2 = new XboxController(1);


  public RobotContainer() {


    m_drivetrain.setDefaultCommand(m_drive_arcade);
    m_spark.setDefaultCommand(m_drive_sparky);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_drive_arcade;
  }
}
