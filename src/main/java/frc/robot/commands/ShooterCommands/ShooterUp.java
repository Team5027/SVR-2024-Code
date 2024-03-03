// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterUp extends Command {
  private final Double targetAngle = (-45.0 + 16.0);
  private final Double marginOfError = 2.0;

  private static int countRan = 0;

  private final Shooter shooter;

  /** Creates a new ShooterUp. */
  public ShooterUp(Shooter s) {
    this.shooter = s;
    addRequirements(s);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("shooter up", "starting");
    // m.set(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("shooter up", "executing loop " + countRan++);
    // shooter.setpivotShooterSpeed(0.3);
    if (shooter.getshooterPivot().getEncoder().getPosition() <= targetAngle - marginOfError) {
      SmartDashboard.putString(
          "shooter do", "go up" + shooter.getshooterPivot().getEncoder().getPosition());
      shooter.setpivotShooterSpeed(0.4);
    } else if (shooter.getshooterPivot().getEncoder().getPosition()
        >= targetAngle + marginOfError) {
      SmartDashboard.putString(
          "shooter do", "go down" + shooter.getshooterPivot().getEncoder().getPosition());
      shooter.setpivotShooterSpeed(-0.3);
    }

    // shooter.setpivotShooterSpeed(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // shooter.setpivotShooterSpeed(0);

    SmartDashboard.putString("shooter up", "finished" + countRan);

    SmartDashboard.putString(
        "shooter do", "stay put" + shooter.getshooterPivot().getEncoder().getPosition());
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // SmartDashboard.putString("shooter up", "checking if finished" + countRan);
    // if ((shooter.getshooterPivot().getEncoder().getPosition() <= targetAngle + marginOfError)
    //     && (shooter.getshooterPivot().getEncoder().getPosition() >= targetAngle - marginOfError))
    // {
    return true;
    // } else {
    //   return false;
    // }
  }
}
