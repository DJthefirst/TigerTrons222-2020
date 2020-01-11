/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.hatchbottraditional;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.examples.hatchbottraditional.Constants.AutoConstants;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.Constants.OIConstants;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.ComplexAuto;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.DefaultDrive;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.DriveDistance;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.GrabHatch;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.HalveDriveSpeed;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.commands.ReleaseHatch;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.examples.hatchbottraditional.subsystems.HatchSubsystem;

import static edu.wpi.first.wpilibj.XboxController.Button;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final HatchSubsystem m_hatchSubsystem = new HatchSubsystem();

  // The autonomous routines

  // A simple auto routine that drives forward a specified distance, and then stops.
  private final Command m_simpleAuto =
      new DriveDistance(AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed,
                        m_robotDrive);

  // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command m_complexAuto = new ComplexAuto(m_robotDrive, m_hatchSubsystem);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new DefaultDrive(
            m_robotDrive,
            () -> m_driverController.getY(GenericHID.Hand.kLeft),
            () -> m_driverController.getX(GenericHID.Hand.kRight)));

    // Add commands to the autonomous command chooser
    m_chooser.addOption("Simple Auto", m_simpleAuto);
    m_chooser.addOption("Complex Auto", m_complexAuto);

    // Put the chooser on the dashboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Grab the hatch when the 'A' button is pressed.
    new JoystickButton(m_driverController, Button.kA.value)
        .whenPressed(new GrabHatch(m_hatchSubsystem));
    // Release the hatch when the 'B' button is pressed.
    new JoystickButton(m_driverController, Button.kB.value)
        .whenPressed(new ReleaseHatch(m_hatchSubsystem));
    // While holding the shoulder button, drive at half speed
    new JoystickButton(m_driverController, Button.kBumperRight.value)
        .whenHeld(new HalveDriveSpeed(m_robotDrive));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
