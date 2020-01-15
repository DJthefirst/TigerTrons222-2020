/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drive_Arcade;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_exampleDrivetrain = new Drivetrain();

  private final Drive_Arcade m_DriveArcade = new Drive_Arcade(m_exampleDrivetrain);



 
  public RobotContainer() {
    
    m_exampleDrivetrain.setDefaultCommand(m_DriveArcade);

    configureButtonBindings();
  }


  private void configureButtonBindings() {
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_DriveArcade;
  }
}
