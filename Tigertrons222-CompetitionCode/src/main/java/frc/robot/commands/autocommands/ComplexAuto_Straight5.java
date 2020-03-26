package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.Arm_Intake;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Shooter_AutoSetSpeed;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class ComplexAuto_Straight5 extends SequentialCommandGroup {
  public ComplexAuto_Straight5() {
    addCommands(new ParallelDeadlineGroup(
      new Auto_DriveForward(120).withTimeout(4),
      new LED_spark(RobotMap.LED_COLOR_AIMING),
      new Arm_Intake(-8000)
      ));
    addCommands(new Auto_DriveForward(-60).withTimeout(3));
    addCommands(new ParallelDeadlineGroup(
      new Drive_AimLimelight(),
      new Pnu_HopperOut(RobotContainer.m_hopper),
      new Shooter_AutoSetSpeed()
      ));
    addCommands(new LED_spark(RobotMap.LED_COLOR_FIREING));
    addCommands(new Auto_Shoot(-3500).withTimeout(5));
    addCommands(new Pnu_HopperOut(RobotContainer.m_hopper));
  }
}
