/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.management.relation.RelationService;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class IntakeReleaseHatch extends InstantCommand {
  
  
  public IntakeReleaseHatch() {
    super();
    requires(Robot.m_Intake);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.m_Intake.ReleaseTheKracken();
  }

}
