package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.motorsub;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Color_Match extends CommandBase {
    private final ColorMatch m_colorMatcher = new ColorMatch();
    
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    public double rotatespeed = 0;
    private String gameData;
    private Color Target;

    private final ControlPanelSubsystem m_subsystem;

    public Color_Match(final ControlPanelSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
    gameData = DriverStation.getInstance().getGameSpecificMessage();

    if (gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
        Target = kBlueTarget;
        break;
        case 'G':
        Target = kGreenTarget;
        break;
        case 'R' :
        Target = kRedTarget;
        break;
        case 'Y' :
        Target = kYellowTarget;
        break;
        default : 
        break;}
      }else{
    }
  }

  @Override
  public void execute() {
    final Color detectedColor = m_subsystem.getColor();

    final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    
    if (match.color == Target) {  
      rotatespeed = 0;
      // System.out.println("Targetfound");
      
    } else {
      rotatespeed = .2;
      // System.out.println("Unknown");
    }
    RobotContainer.m_motorsubby.motorspinner(rotatespeed);

  }

  @Override
  public void end(final boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}