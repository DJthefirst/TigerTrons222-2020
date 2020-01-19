/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Color_Match;
import frc.robot.commands.Drive_Arcade;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HatchSubsystem;
import frc.robot.subsystems.SparkMaxTest;
import frc.robot.commands.Pnu_HatchIn;
import frc.robot.commands.Pnu_HatchOut;
import frc.robot.commands.SparkMax_DefaultTest;
import frc.robot.commands.SparkMax_PIDTest;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final SparkMaxTest m_sparkTest = new SparkMaxTest();
  private final ControlPanelSubsystem m_colorSubsystem = new ControlPanelSubsystem();
  private final HatchSubsystem m_hatchSubsystem = new HatchSubsystem();

  private final Drive_Arcade m_drive_arcade = new Drive_Arcade(m_drivetrain);
  private final SparkMax_DefaultTest m_drive_sparky = new SparkMax_DefaultTest(m_sparkTest);
  private final Color_Match m_colormatch = new Color_Match(m_colorSubsystem);
  

  public static final XboxController Controller = new XboxController(0);
  public static final XboxController Controller2 = new XboxController(1);
  
  //Controller 1
  JoystickButton A1 = new JoystickButton(Controller, 1);
	JoystickButton B1 = new JoystickButton(Controller, 2);
	JoystickButton X1 = new JoystickButton(Controller, 3);
	JoystickButton Y1 = new JoystickButton(Controller, 4);
	JoystickButton LB1 = new JoystickButton(Controller, 5);
	JoystickButton RB1 = new JoystickButton(Controller, 6);
	JoystickButton BK1 = new JoystickButton(Controller, 7);
	JoystickButton ST1 = new JoystickButton(Controller, 8);
  JoystickButton LS1 = new JoystickButton(Controller, 9);
	JoystickButton RS1 = new JoystickButton(Controller, 10);

	//Controller 2
  JoystickButton A2 = new JoystickButton(Controller2, 1);
	JoystickButton B2 = new JoystickButton(Controller2, 2);
	JoystickButton X2 = new JoystickButton(Controller2, 3);
	JoystickButton Y2 = new JoystickButton(Controller2, 4);
	JoystickButton LB2 = new JoystickButton(Controller2, 5);
	JoystickButton RB2 = new JoystickButton(Controller2, 6);
	JoystickButton BK2 = new JoystickButton(Controller2, 7);
	JoystickButton ST2 = new JoystickButton(Controller2, 8);
  JoystickButton LS2 = new JoystickButton(Controller2, 9);
	JoystickButton RS2 = new JoystickButton(Controller2, 10);

  public RobotContainer() {
    configureButtonBindings();

    m_drivetrain.setDefaultCommand(m_drive_arcade);
    m_sparkTest.setDefaultCommand(m_drive_sparky);
    m_colorSubsystem.setDefaultCommand(m_colormatch);
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    A1.whenPressed(new Pnu_HatchOut(m_hatchSubsystem));	
    A1.whenReleased(new Pnu_HatchIn(m_hatchSubsystem));
    B1.whileHeld(new SparkMax_PIDTest(m_sparkTest));


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
