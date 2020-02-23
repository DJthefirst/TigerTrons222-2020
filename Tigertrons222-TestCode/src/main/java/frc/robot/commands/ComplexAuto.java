package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto_Rotate;
import frc.robot.commands.Autodrive_forward;

public class ComplexAuto extends SequentialCommandGroup {

  public void ComplexAuto() {
   addCommands(new Auto_Rotate(5, 45));
   addCommands(new Autodrive_forward(5, 5));
   
  }




   // new(new Auto_Rotate(5, 45), new Autodrive_forward(5, 5), new Auto_Rotate(5, 135));
  
}
