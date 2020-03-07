package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Shooter_SetSpeed;

public class Btn_AimRobot extends SequentialCommandGroup {
  public Btn_AimRobot() {
    addCommands(new ParallelDeadlineGroup(
      new Drive_AimLimelight(),
      new LED_spark(RobotMap.LED_COLOR_AIMING),
      new Pnu_HopperOut(RobotContainer.m_hopper),
      new Shooter_SetSpeed(-3500)
      ));
    addCommands(new ParallelDeadlineGroup(
      new LED_spark(RobotMap.LED_COLOR_ALIGNED),
      new Shooter_SetSpeed(0)
      ));
      
  }
}