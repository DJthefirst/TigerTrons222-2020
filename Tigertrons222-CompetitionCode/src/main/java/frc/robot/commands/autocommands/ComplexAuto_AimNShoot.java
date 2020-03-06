package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Shooter_SetSpeed;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class ComplexAuto_AimNShoot extends SequentialCommandGroup {
  public ComplexAuto_AimNShoot() {
    addCommands(new LED_spark(.93));
    addCommands(new ParallelDeadlineGroup(
      new Drive_AimLimelight(),
      new Pnu_HopperOut(RobotContainer.m_hopper),
      new Shooter_SetSpeed(-3500)
      ));
    addCommands(new LED_spark(.93));
    addCommands(new Auto_Shoot(-3500).withTimeout(5));
    addCommands(new Pnu_HopperOut(RobotContainer.m_hopper));
  }
}
