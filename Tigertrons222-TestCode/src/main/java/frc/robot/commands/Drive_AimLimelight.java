package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Drive_AimLimelight extends CommandBase{

    private final Drivetrain m_subsystem;
    NetworkTable table;
    double end = 10;
    double xval;
    double x =0;
    double rotateSpeed;

    public Drive_AimLimelight()
    {
        m_subsystem = RobotContainer.m_drivetrain;
        addRequirements(m_subsystem);
    }

    @Override 
    public void initialize(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
        table.getEntry("pipeline").setNumber(1);
    }
    @Override 
    public void execute()
    {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        x ++;
        //read values periodically
        double xx = tx.getDouble(0.0);
        double yy = ty.getDouble(0.0);
        double Are = ta.getDouble(0.0);
        //double offset = 0; //2.57

        SmartDashboard.putNumber("LimelightX", xx);
        SmartDashboard.putNumber("LimelightY", yy);
        SmartDashboard.putNumber("LimelightArea", Are);

        System.out.println("x;"+ xx +" y;"+ yy +" area;"+ Are);

        //caluate end
        end = (end/1.1) + Math.abs(xx);

        if(Math.abs(xx) > 4.5){
        xx = xx/25;
            rotateSpeed = xx;
        }
        else{
            rotateSpeed = -m_subsystem.LimePidRotate(0, xx);
           //rotateSpeed = rotateSpeed*xx/Math.abs(xx);
        }
        
        
       
      //optional
		 if (Math.abs(rotateSpeed) < 0.10) {
		 	// within 10% joystick, make it zero 
		 	rotateSpeed = 0;
         }
        
         if (rotateSpeed > .7) {
		 	// within 100% joystick, make it zero 
		 	rotateSpeed = .7;
         }
        
         if (rotateSpeed < -.7) {
		 	// within 100% joystick, make it zero 
		 	rotateSpeed = -.7;
         }

        m_subsystem.arcadeDrive(0, rotateSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        //table.getEntry("pipeline").setNumber(0);
    }
  
    
    @Override
    public boolean isFinished() {
        return x > 100;
      //return end < .2;
    }
}