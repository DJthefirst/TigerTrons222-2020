package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;


public class ControlPanelSubsystem extends SubsystemBase {

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    
    public ControlPanelSubsystem() {

}

public Color getColor ()
{
    Color tempcolor = m_colorSensor.getColor();
    return tempcolor;
}
}