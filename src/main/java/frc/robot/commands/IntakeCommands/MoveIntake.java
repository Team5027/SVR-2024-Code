// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class MoveIntake extends Command {
  private final Intake intakeSubsystem;

  /** Creates a new MoveIntake. */
  public MoveIntake(Intake intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    // i.setspeed(0.2);
    // SmartDashboard.putNumber("help", 1);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //  i.setspeed(0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setspeed(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // motor stops
    // intakeSubsystem.setspeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // it don't finish on its own
    return false;
  }
}
