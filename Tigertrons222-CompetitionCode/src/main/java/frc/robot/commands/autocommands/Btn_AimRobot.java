package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Shooter_SetSpeed;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class Btn_AimRobot extends ParallelCommandGroup {
  public Btn_AimRobot() {
    addCommands(new LED_spark(RobotMap.LED_COLOR_AIMING));
    addCommands(new Drive_AimLimelight());
    addCommands(new Pnu_HopperOut(RobotContainer.m_hopper));
    addCommands(new Shooter_SetSpeed(-3500));
  }
}
