/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveAutoLeft extends Command {
  public Timer timeMovingForwards = null;
  public DriveAutoLeft() {
    requires(Robot.m_Drivetrain);
    timeMovingForwards = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timeMovingForwards.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_Drivetrain.tankDrive(0.5, 0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timeMovingForwards.hasPeriodPassed(3);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_Drivetrain.tankDrive(0, 0);  
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
