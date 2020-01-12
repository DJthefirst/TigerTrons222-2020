/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.examples.gearsbot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.examples.gearsbot.commands.Autonomous;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.CloseClaw;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.OpenClaw;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.Pickup;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.Place;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.PrepareToPickup;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.SetElevatorSetpoint;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.SetWristSetpoint;
import edu.wpi.first.wpilibj.examples.gearsbot.commands.TankDrive;
import edu.wpi.first.wpilibj.examples.gearsbot.subsystems.Claw;
import edu.wpi.first.wpilibj.examples.gearsbot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.examples.gearsbot.subsystems.Elevator;
import edu.wpi.first.wpilibj.examples.gearsbot.subsystems.Wrist;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_drivetrain = new DriveTrain();
  private final Elevator m_elevator = new Elevator();
  private final Wrist m_wrist = new Wrist();
  private final Claw m_claw = new Claw();

  private final Joystick m_joystick = new Joystick(0);

  private final CommandBase m_autonomousCommand =
      new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Put Some buttons on the SmartDashboard
    SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0, m_elevator));
    SmartDashboard.putData("Elevator Platform", new SetElevatorSetpoint(0.2, m_elevator));
    SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.3, m_elevator));

    SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0, m_wrist));
    SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45, m_wrist));

    SmartDashboard.putData("Open Claw", new OpenClaw(m_claw));
    SmartDashboard.putData("Close Claw", new CloseClaw(m_claw));

    SmartDashboard
        .putData("Deliver Soda", new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));

    // Assign default commands
    m_drivetrain.setDefaultCommand(new TankDrive(() -> m_joystick.getY(Hand.kLeft),
        () -> m_joystick.getY(Hand.kRight), m_drivetrain));

    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putData(m_elevator);
    SmartDashboard.putData(m_wrist);
    SmartDashboard.putData(m_claw);

    // Call log method on all subsystems
    m_wrist.log();
    m_elevator.log();
    m_drivetrain.log();
    m_claw.log();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton dpadUp = new JoystickButton(m_joystick, 5);
    final JoystickButton dpadRight = new JoystickButton(m_joystick, 6);
    final JoystickButton dpadDown = new JoystickButton(m_joystick, 7);
    final JoystickButton dpadLeft = new JoystickButton(m_joystick, 8);
    final JoystickButton l2 = new JoystickButton(m_joystick, 9);
    final JoystickButton r2 = new JoystickButton(m_joystick, 10);
    final JoystickButton l1 = new JoystickButton(m_joystick, 11);
    final JoystickButton r1 = new JoystickButton(m_joystick, 12);

    // Connect the buttons to commands
    dpadUp.whenPressed(new SetElevatorSetpoint(0.2, m_elevator));
    dpadDown.whenPressed(new SetElevatorSetpoint(-0.2, m_elevator));
    dpadRight.whenPressed(new CloseClaw(m_claw));
    dpadLeft.whenPressed(new OpenClaw(m_claw));

    r1.whenPressed(new PrepareToPickup(m_claw, m_wrist, m_elevator));
    r2.whenPressed(new Pickup(m_claw, m_wrist, m_elevator));
    l1.whenPressed(new Place(m_claw, m_wrist, m_elevator));
    l2.whenPressed(new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommand;
  }
}
