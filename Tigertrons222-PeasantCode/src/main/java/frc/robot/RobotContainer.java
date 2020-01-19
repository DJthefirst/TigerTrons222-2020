/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.Motorzoomyzoomy;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drive_Arcade;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.motorsub;
import frc.robot.commands.Color_Match;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_exampleDrivetrain = new Drivetrain();
  private final motorsub m_motorsubby = new motorsub();
  private final ControlPanelSubsystem m_matchcolor = new ControlPanelSubsystem();
  
  private final Drive_Arcade m_DriveArcade = new Drive_Arcade(m_exampleDrivetrain);
  private final Motorzoomyzoomy  m_motorspineyspiney = new Motorzoomyzoomy(m_motorsubby);
  private final Color_Match m_matchycolor = new Color_Match(m_matchcolor);

  public RobotContainer() {
    
    m_exampleDrivetrain.setDefaultCommand(m_DriveArcade);
   // m_motorsubby.setDefaultCommand(m_motorspineyspiney);
    m_matchcolor.setDefaultCommand(m_matchycolor);
    configureButtonBindings();
  }


  private void configureButtonBindings() {
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_DriveArcade;
  }
}
