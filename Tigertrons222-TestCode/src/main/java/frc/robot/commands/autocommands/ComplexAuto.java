package frc.robot.commands.autocommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Pnu_HopperOut;
import frc.robot.commands.autocommands.Autodrive_forward;

public class ComplexAuto extends SequentialCommandGroup {
  public ComplexAuto(){
    addCommands(new Autodrive_forward(5,120));
    addCommands(new Auto_Rotate(5,-30));
    addCommands(new Pnu_HopperOut(RobotContainer.m_unknown));
    addCommands(new Auto_Shoot());
    addCommands(new Autodrive_forward(5,-60));
  }
}
