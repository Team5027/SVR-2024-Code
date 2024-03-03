package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel.PeriodicFrame;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private final CANSparkMax ClimberMotor = new CANSparkMax(20, MotorType.kBrushless);
  private final RelativeEncoder ClimberEncoder = ClimberMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber(" Climber Encoder", ClimberEncoder.getPosition());

    SmartDashboard.putNumber(" Climber Velocity", ClimberEncoder.getVelocity());
  }

  public void setMotor(double speed) {
    ClimberMotor.set(speed);
  }

  public double getLeftEncoder() {
    return ClimberEncoder.getPosition();
  }

  public void resetEncoder() {
    ClimberEncoder.setPosition(0);
    ClimberMotor.setIdleMode(IdleMode.kBrake);
  }

  public void setPeriodicStatus() {
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 10);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 20);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 20);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 50);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 20);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 200);
    ClimberMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 200);
  }
}
