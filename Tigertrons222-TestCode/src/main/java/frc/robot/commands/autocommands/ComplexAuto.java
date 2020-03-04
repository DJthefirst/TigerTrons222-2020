package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Conveyor_Intake;
import frc.robot.commands.Drive_AimLimelight;
import frc.robot.commands.LED_spark;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.Shooter_SetSpeed;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class ComplexAuto extends SequentialCommandGroup {
  public ComplexAuto(){
    addCommands(new ParallelCommandGroup(
      new LED_spark(.57),
      new Conveyor_Intake(Constants.conveyor_speed),
      new Auto_DriveForward(5,180)
      ));
    addCommands(new Auto_Rotate(5,180));
    addCommands(new Auto_DriveForward(5,120));
    addCommands(new Auto_Rotate(5,-120));
    addCommands(new ParallelDeadlineGroup(
      new Drive_AimLimelight(),
      new Pnu_HopperOut(RobotContainer.m_hopper),
      new Shooter_SetSpeed(-3500)
      ));
    addCommands(new LED_spark(.93));
    addCommands(new Auto_Shoot(-3500));
  }
}
