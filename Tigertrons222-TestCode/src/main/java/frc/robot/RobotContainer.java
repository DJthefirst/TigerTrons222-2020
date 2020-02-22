/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Imu;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.PnuHatchSubsystem;
import frc.robot.subsystems.PnuShiftSubsystem;
import frc.robot.subsystems.PnuUnknownSubsystem;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Limelight;

import frc.robot.commands.Color_Match;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.Conveyor_Default;
import frc.robot.commands.Drive_Arcade;
import frc.robot.commands.Drive_PathFinder;

import frc.robot.commands.Gyro_GetData;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Limelight_GetData;
import frc.robot.commands.Pnu_HatchIn;
import frc.robot.commands.Pnu_HatchOut;
import frc.robot.commands.Pnu_ShiftIn;
import frc.robot.commands.Pnu_ShiftOut;
import frc.robot.commands.Pnu_UnknownIn;
import frc.robot.commands.Pnu_UnknownOut;
import frc.robot.commands.Turret_Rotation;
import frc.robot.commands.Turret_SetSpeed;
import frc.robot.commands.Auto_Rotate;
import frc.robot.commands.Autodrive_forward;
import frc.robot.commands.Btn_ResetEncoder;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Drivetrain m_drivetrain = new Drivetrain();
  public static final Conveyor m_conveyor = new Conveyor();
  public static final Turret m_turret = new Turret();
  public static final LED m_LED = new LED();
  private final ControlPanelSubsystem m_colorSubsystem = new ControlPanelSubsystem();
  private final PnuHatchSubsystem m_hatchSubsystem = new PnuHatchSubsystem();
  private final PnuShiftSubsystem m_shift = new PnuShiftSubsystem();
  private final PnuUnknownSubsystem m_unknown = new PnuUnknownSubsystem();
  public static final Imu m_gyro = new Imu();
  public static final Limelight m_limelight = new Limelight();

  // Default Commands Only
  private final Drive_Arcade m_drive_arcade = new Drive_Arcade(m_drivetrain);
  private final Color_Match m_colormatch = new Color_Match(m_colorSubsystem);
  private final Gyro_GetData m_gyroget = new Gyro_GetData(m_gyro);
  private final Limelight_GetData m_limelightGetData = new Limelight_GetData(m_limelight);

  public static final XboxController Controller = new XboxController(0);
  public static final XboxController Controller2 = new XboxController(1);

  // Controller 1
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

  // Controller 2
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

    // Default Commands Only
    m_drivetrain.setDefaultCommand(m_drive_arcade);
    m_colorSubsystem.setDefaultCommand(m_colormatch);
    m_gyro.setDefaultCommand(m_gyroget);
    m_limelight.setDefaultCommand(m_limelightGetData);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * 
   * @throws IOException
   */
  private void configureButtonBindings(){
    // A1.whenPressed(new Pnu_HatchOut(m_hatchSubsystem));
    // A1.whenReleased(new Pnu_HatchIn(m_hatchSubsystem));
    RB1.whenPressed(new Pnu_ShiftOut(m_shift));
    RB1.whenReleased(new Pnu_ShiftIn(m_shift));
    X1.whileHeld(new Autodrive_forward(0, 120));
    Y1.whenPressed(new Auto_Rotate(0, -90));
    B1.whileHeld(new Btn_ResetEncoder());
    A1.whileHeld(new ComplexAuto());

    
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
