// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class IntakePivotCommand extends Command {

  private final Intake intakeSubsystem;
  private final CANSparkMax pivotMotor;
  private final RelativeEncoder intakeP;
  // private final XboxController j;

  /** Creates a new IntakePivot. */
  public IntakePivotCommand(Intake inSubsystem, double speed) {
    this.intakeSubsystem = inSubsystem;
    this.pivotMotor = inSubsystem.getintakePivotMotor();
    this.intakeP = inSubsystem.getintakePivotMotor().getEncoder();
    // this.j = i.getcontroller();

    this.intakeP.setPositionConversionFactor(1.0);
    // this.intakeP.reset();
    addRequirements(intakeSubsystem);
    // this.intakeP.setPositionConversionFactor(360.0);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // p.set(0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // SmartDashboard.putNumber(
    //     "Intake Pivot Encoder Position", intakeP.getPositionConversionFactor());

    if (intakeSubsystem.getisForward()) {
      intakeSubsystem.getintakePivotMotor().set(-intakeSubsystem.getspeed());
    } else {
      intakeSubsystem.getintakePivotMotor().set(intakeSubsystem.getspeed());
    }

    SmartDashboard.putBoolean("current front limit", !intakeSubsystem.getfrontLimit().get());
    SmartDashboard.putBoolean("current back limit", !intakeSubsystem.getbackLimit().get());
    SmartDashboard.putNumber("current speed", intakeSubsystem.getspeed());
    SmartDashboard.putNumber(
        "intake encoder",
        intakeSubsystem.getintakePivotMotor().getEncoder().getPositionConversionFactor());

    // inverted help me
    if (!intakeSubsystem.getfrontLimit().get() && intakeSubsystem.getisForward()) {
      intakeSubsystem.setspeed(0);
      intakeSubsystem.setisForward(false);
      //  new IntakeFrontLimit(i);
    } else if (!intakeSubsystem.getbackLimit().get() && !intakeSubsystem.getisForward()) {
      intakeSubsystem.setspeed(0);
      intakeSubsystem.setisForward(true);
      // new intakeSubsystemBackLimit(i);
    }

    // if (j.getRawButtonPressed(2)) {
    //   intakeSubsystem.setspeed(0.5);
    // } else {
    //   // p.setIdleMode(IdleMode.kBrake);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setspeed(0.0);
    System.out.println("Intake stop");
  }

  // Returns true when the command should end.//
  @Override
  public boolean isFinished() {
    return false;
  }
}
