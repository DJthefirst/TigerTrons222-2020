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
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Imu;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.PnuHopperSubsystem;
import frc.robot.subsystems.PnuShiftSubsystem;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Pnu3Subsystem;
import frc.robot.commands.Drive_Arcade;
import frc.robot.commands.Intake_Limit;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Limelight_Led;
import frc.robot.commands.Pnu_HopperIn;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Pnu_ShiftIn;
import frc.robot.commands.Pnu_ShiftOut;
import frc.robot.commands.Publish_data;
import frc.robot.commands.Shooter_SetSpeed;
import frc.robot.commands.autocommands.Auto_Shoot;
import frc.robot.commands.autocommands.Btn_ResetEncoder;
import frc.robot.commands.autocommands.ComplexAuto_Straight5;
import frc.robot.commands.Conveyor_Intake;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.Arm_Intake;

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
  public static final Shooter m_Shooter = new Shooter();
  public static final LED m_LED = new LED();
  public static final ControlPanelSubsystem m_colorSubsystem = new ControlPanelSubsystem();
  public static final Pnu3Subsystem m_3Subsystem = new Pnu3Subsystem();
  public static final PnuShiftSubsystem m_shift = new PnuShiftSubsystem();
  public static final PnuHopperSubsystem m_hopper = new PnuHopperSubsystem();
  public static final Imu m_gyro = new Imu();
  public static final Limelight m_limelight = new Limelight();
  public static final Intake m_arm = new Intake();

  // Default Commands Only
  private final Drive_Arcade m_drive_arcade = new Drive_Arcade(m_drivetrain);
  private final Publish_data m_publish = new Publish_data(m_limelight);
  private final Intake_Limit m_intakeLimit = new Intake_Limit(m_arm);

  //Auto Protocalls
  //private final ComplexAuto_Straight5 m_auto = new ComplexAuto_Straight5();

  //Settup controllers
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
    m_limelight.setDefaultCommand(m_publish);
    m_arm.setDefaultCommand(m_intakeLimit);
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
    LB1.whenPressed(new Pnu_HopperOut(m_hopper));
    LB1.whenReleased(new Pnu_HopperIn(m_hopper));
    ST1.whenPressed(new Limelight_Led());

    Y1.whileHeld(new Arm_Intake(-10000));
    //Y1.whileHeld(new Arm_Intake(-8000));
    //X1.whileHeld(new Arm_Intake(-6000));
    
    //Y1.whileHeld(new Shooter_Conveyor(-4000,-6000));
    X1.whileHeld(new Conveyor_Intake(Constants.conveyor_speed));
    //Y1.whileHeld(new Conveyor_Intake(-12000));
    A1.whileHeld(new Conveyor_Intake(-6000));
    B1.whileHeld(new Shooter_SetSpeed(4500));
    A2.whileHeld(new Drive_AimLimelight());
    //X1.whileHeld(new Autodrive_forward(0, 120));
    Y2.whileHeld(new Auto_Shoot(-3500));
    B2.whileHeld(new Btn_ResetEncoder());
    X2.whileHeld(new ComplexAuto_Straight5());

    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new ComplexAuto_Straight5();
  }
}
