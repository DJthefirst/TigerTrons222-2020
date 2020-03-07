package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class ComplexAuto_TurnNShoot extends SequentialCommandGroup {
  public ComplexAuto_TurnNShoot() {
    addCommands(new Auto_DriveForward(120));
    addCommands(new LED_spark(RobotMap.LED_COLOR_AIMING));
    addCommands(new Drive_AimLimelight());
    addCommands(new Pnu_HopperOut(RobotContainer.m_hopper));
    addCommands(new LED_spark(RobotMap.LED_COLOR_FIREING));
    addCommands(new Auto_Shoot(-3500));
  }
}
