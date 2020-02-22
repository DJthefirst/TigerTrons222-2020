package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto_Rotate;
import frc.robot.commands.Autodrive_forward;


public class ComplexAuto extends SequentialCommandGroup {

  public void ComplexAuto() {
    addCommands(
        new Autodrive_forward(0, 5),
        new Auto_Rotate(0, 45),
        new Autodrive_forward(0, 5),
        new Auto_Rotate(0, 135)
        );
  }
}