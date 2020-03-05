package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.autocommands.Auto_DriveForward;

public class ComplexAuto1 extends SequentialCommandGroup {
  public ComplexAuto1(){
    addCommands(new Auto_DriveForward(5,120));
    addCommands(new Auto_Rotate(5,-30));
    addCommands(new Pnu_HopperOut(RobotContainer.m_hopper));
    addCommands(new Auto_Shoot(-3500));
    addCommands(new Auto_DriveForward(5,-60));
  }
}
