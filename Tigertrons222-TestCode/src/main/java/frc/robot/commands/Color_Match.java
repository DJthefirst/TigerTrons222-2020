package frc.robot.commands;

import frc.robot.subsystems.ControlPanelSubsystem;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Color_Match extends CommandBase {
    private final ColorMatch m_colorMatcher = new ColorMatch();
    
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);


    private final ControlPanelSubsystem m_subsystem;

    public Color_Match(ControlPanelSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);   

  }

  
  @Override
  public void execute() {
    Color detectedColor = m_subsystem.getColor();

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
        //System.out.println("Blue");
    } else if (match.color == kRedTarget) {
        //System.out.println("Red");
    } else if (match.color == kGreenTarget) {
        //System.out.println("Green");
    } else if (match.color == kYellowTarget) {
        //System.out.println("Yellow");
    } else {
        //System.out.println("Unknown");
    }



  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}