package frc.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

//----------Subsytem-Creation----------

// All of our Robot Subsystems are created as Objects
// public static final TypeOfObject m_newObjectName = new TypeOfObject();
public static final Drivetrain m_Drivetrain = new Drivetrain();

//----------Default-Commands----------
//
//Commands being used as a default commands such as Drive_Arcade need to be created as objects in order to be run
//Default Commands require the subsystem they are being called by to run
//*Note Proper nameing is paramount for good codeing ex. our team uses "NameOfSubsystem"_CommandPurpous to orgainize commands
//private final TypeOfCommand m_nameOfCommand = new TypeOfCommand(m_nameOfSubsystemRunningCommand);
private final Drive_Arcade m_Drive_Arcade = new Drive_Arcade(m_Drivetrain);

//----------Settup-AutomousCommands----------
//
//Similar to default commands except we do not require the subsytem to run the command
//*Note add all autonomus commands that might be used during a match
//private final TypeOfCommand m_nameOfCommand = new TypeOfCommand();
private final Auto_Example m_auto_1 = new Auto_Example();

//----------Settup-Controllers----------
//
//Create the controllers used in used for your robot
//*You can use a varitey of controllers GamepadBase,Joystick,JoystickBase,XboxController our team uses xbox
//public static final TypeOfController nameOfController = new TypeOfController(port 0,1,2..);
public static final XboxController Controller = new XboxController(0);
public static final XboxController Controller2 = new XboxController(1);

//----------Settup-Controller-Buttons----------
//Give IDs to buttons Name appropriately for ease of use
//JoystickButton buttonName = new JoystickButton(nameOfController, buttonID 1,2,3..);

  // Controller 1
  JoystickButton A1 = new JoystickButton(Controller, 1);
  JoystickButton B1 = new JoystickButton(Controller, 2);
  JoystickButton X1 = new JoystickButton(Controller, 3);
  JoystickButton Y1 = new JoystickButton(Controller, 4);
  JoystickButton LB1 = new JoystickButton(Controller, 5);
  JoystickButton RB1 = new JoystickButton(Controller, 6);
  JoystickButton BK1 = new JoystickButton(Controller, 7);
  JoystickButton ST1 = new JoystickButton(Controller, 8);
  JoystickButton LS1 = new JoystickButton(Controller, 9);
  JoystickButton RS1 = new JoystickButton(Controller, 10);

  // Controller 2
  JoystickButton A2 = new JoystickButton(Controller2, 1);
  JoystickButton B2 = new JoystickButton(Controller2, 2);
  JoystickButton X2 = new JoystickButton(Controller2, 3);
  JoystickButton Y2 = new JoystickButton(Controller2, 4);
  JoystickButton LB2 = new JoystickButton(Controller2, 5);
  JoystickButton RB2 = new JoystickButton(Controller2, 6);
  JoystickButton BK2 = new JoystickButton(Controller2, 7);
  JoystickButton ST2 = new JoystickButton(Controller2, 8);
  JoystickButton LS2 = new JoystickButton(Controller2, 9);
  JoystickButton RS2 = new JoystickButton(Controller2, 10);

  public RobotContainer() {
    configureButtonBindings();

    //----------Start-Default_Commands----------
    //m_subsystemName.setDefaultCommand(m_nameOfCommand)
    m_Drivetrain.setDefaultCommand(m_Drive_Arcade);
  }

  
  private void configureButtonBindings(){

    //----------Configure Buttons----------
    //This is where you bind Buttons to commands
    //There are many types of button control such as whenPressed, whenReleased, whileHeldand whileActive to name a few
    //
    //ButtonName.controlType(new commandType());

  } 

  public Command getAutonomousCommand() {
    return new Auto_Example();
  }
}