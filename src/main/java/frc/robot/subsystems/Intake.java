package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel.PeriodicFrame;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.IntakeCommands.IntakePivotCommand;

public class Intake extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(15, MotorType.kBrushless);
  private final CANSparkMax intakePivotMotor = new CANSparkMax(14, MotorType.kBrushless);
  private final RelativeEncoder intakePivotEncoder = intakePivotMotor.getEncoder();
  private final DigitalInput frontLimit = new DigitalInput(0);
  private final DigitalInput backLimit = new DigitalInput(1);
  // private final JoystickButton x;
  private boolean isForward = true;
  private double speed = 0.0;

  public void PivotIntake(double speed) {
    intakePivotMotor.set(speed);
  }

  public double PivotIntakeEncoder() {
    return intakePivotEncoder.getPosition();
  }

  public void initDefaultCommand() {
    // setDefaultCommand(new IntakeCommand(this, intakeMotor));
    setDefaultCommand(new IntakePivotCommand(this, speed));
  }

  @Override
  public void periodic() {}

  public void setPeriodicStatus() {
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    intakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);
    ;
  }

  public CANSparkMax getintakeMotor() {

    return this.intakeMotor;
  }

  public CANSparkMax getintakePivotMotor() {
    return this.intakePivotMotor;
  }

  public boolean getisForward() {
    return this.isForward;
  }

  public void setisForward(boolean b) {
    this.isForward = b;
  }

  public double getspeed() {
    return this.speed;
  }

  public void setspeed(double s) {
    this.speed = s;
  }

  public DigitalInput getfrontLimit() {
    return this.frontLimit;
  }

  public DigitalInput getbackLimit() {
    return this.backLimit;
  }
}
