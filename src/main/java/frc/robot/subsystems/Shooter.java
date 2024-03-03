package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel.PeriodicFrame;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ShooterCommands.ShooterCommand;

public class Shooter extends SubsystemBase {

  private final CANSparkMax leftShooterMotor;
  private final CANSparkMax rightShooterMotor;
  private final CANSparkMax bottomShooterMotor;
  private final CANSparkMax shooterPivot;
  private final RelativeEncoder pivotEncoder;
  private final XboxController controller;
  private double shooterSpeed;
  private double pivotShooterSpeed;
  private double topWheelSpeed;

  double motorPosition = 180; // integer between 0-360
  double rate;
  // pivotEncoder.reset();

  public Shooter(XboxController controller3) {
    leftShooterMotor = new CANSparkMax(17, MotorType.kBrushless);
    rightShooterMotor = new CANSparkMax(16, MotorType.kBrushless);
    bottomShooterMotor = new CANSparkMax(19, MotorType.kBrushless);
    shooterPivot = new CANSparkMax(18, MotorType.kBrushless);
    controller = controller3;
    pivotEncoder = shooterPivot.getEncoder();
    shooterSpeed = 0.0;
    pivotShooterSpeed = 0.0;
    topWheelSpeed = 0.0;
    // rate = pivotEncoder.getRate();

    // this.setDefaultCommand(new ShooterCommand(this, pivotEncoder));
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ShooterCommand(this, shooterPivot));
    // setDefaultCommand(new ShooterCommand(this, leftShooterMotor));
  }

  @Override
  public void periodic() {}

  public void setPeriodicStatus() {
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);

    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);
  }

  public CANSparkMax getleftShooterMotor() {

    return this.leftShooterMotor;
  }

  public CANSparkMax getrightShooterMotor() {
    return this.rightShooterMotor;
  }

  public CANSparkMax getbottomShooterMotor() {
    return this.bottomShooterMotor;
  }

  public CANSparkMax getshooterPivot() {
    return this.shooterPivot;
  }

  public XboxController getcontroller() {
    return this.controller;
  }

  public XboxController getController() {
    return controller;
  }

  public void setshooterSpeed(double s) {
    this.shooterSpeed = s;
  }

  public double getshooterSpeed() {
    return this.shooterSpeed;
  }

  public double getpivotShooterSpeed() {
    return this.pivotShooterSpeed;
  }

  public void setpivotShooterSpeed(double p) {
    this.pivotShooterSpeed = p;
  }

  public double gettopWheelSpeed() {
    return this.topWheelSpeed;
  }

  public void settopWheelSpeed(double t) {
    this.topWheelSpeed = t;
  }
}
