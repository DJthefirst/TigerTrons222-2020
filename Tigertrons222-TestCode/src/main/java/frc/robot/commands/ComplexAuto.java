package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.Auto_Rotate;
import frc.robot.commands.Autodrive_forward;

public class ComplexAuto extends SequentialCommandGroup {
  public ComplexAuto(){
    addCommands(new Autodrive_forward(5,120));
    addCommands(new Auto_Rotate(5,-30));
    addCommands(new Pnu_UnknownOut(RobotContainer.m_unknown));
    addCommands(new Auto_Shoot());
    addCommands(new Autodrive_forward(5,-60));
  }
}
