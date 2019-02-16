/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FollowVisionTarget extends Command {
  private final double TURN_SPEED = 0.125; //Percentage of 100
  private final double ADVANCE_SPEED = 0.5; //Percentage of 100
  private final double TARGET_ANGLE_LIMIT_RIGHT = 5; // Angle Degrees
  private final double TARGET_ANGLE_LIMIT_LEFT = -5; // Angle Degrees
  private final double DISTANCE_LIMIT = 30; // cm away

  public FollowVisionTarget() {
    requires(Robot.m_Drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if (Robot.m_visionTrackingClient.isConnected()) {

      if (Robot.m_visionTrackingClient.hasVisionTarget()) {
        double targetAngle = Robot.m_visionTrackingClient.targetAngle();
        double targetDistance = Robot.m_visionTrackingClient.targetDistance();

        if (targetAngle > TARGET_ANGLE_LIMIT_LEFT && targetDistance > DISTANCE_LIMIT) {
          // turn right
          Robot.m_Drivetrain.tankDrive(-TURN_SPEED, TURN_SPEED);
        } 
        else if (targetAngle < TARGET_ANGLE_LIMIT_RIGHT && targetDistance > DISTANCE_LIMIT) {
          // left
          Robot.m_Drivetrain.tankDrive(TURN_SPEED, -TURN_SPEED);
        } 
        else if (targetDistance > DISTANCE_LIMIT) {
          Robot.m_Drivetrain.tankDrive(ADVANCE_SPEED, ADVANCE_SPEED);
        } 
        else {
          Robot.m_Drivetrain.tankDrive(0, 0);
        }
      } 
      else {
        Robot.m_Drivetrain.tankDrive(0, 0);
      }
    } 
    else {
      Robot.m_Drivetrain.tankDrive(0, 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
