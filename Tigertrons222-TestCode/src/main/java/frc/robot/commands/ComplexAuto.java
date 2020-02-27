package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto_Rotate;
import frc.robot.commands.Autodrive_forward;

public class ComplexAuto extends CommandGroupBase {

  @Override
  public void addCommands(Command... commands) {
    new SequentialCommandGroup(new Autodrive_forward(5, 5), new Auto_Rotate(5, 45));
  }






   // new(new Auto_Rotate(5, 45), new Autodrive_forward(5, 5), new Auto_Rotate(5, 135));
  
}
