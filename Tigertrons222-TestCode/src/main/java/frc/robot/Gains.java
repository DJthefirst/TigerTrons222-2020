package frc.robot;

public class Gains {
	public final double kP;
	public final double kI;
	public final double kD;
	public final double kFF;
	public final double kIzone;
	public final double kMinOutput;
	public final double kMaxOutput;
	public final double maxRpm;
	
	public Gains(double _kP, double _kI, double _kD, double _kFF, double _kIzone, double _kMinOutput, double _kMaxOutput, double _maxRpm){
		kP = _kP;
		kI = _kI;
		kD = _kD;
		kFF = _kFF;
		kIzone = _kIzone;
		kMinOutput =  _kMinOutput;
		kMaxOutput =  _kMaxOutput;
		maxRpm = _maxRpm;
	}
}
