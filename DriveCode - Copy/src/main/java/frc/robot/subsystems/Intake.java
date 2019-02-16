/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeStop;


public class Intake extends Subsystem {
  private final double SPEED_OF_INTAKE = 0.25;
  DoubleSolenoid hatchSolenoids = null;
  WPI_TalonSRX IntakeMotor = null;


  public Intake(){
    IntakeMotor = new WPI_TalonSRX(RobotMap.IntakeMotorPort);
    hatchSolenoids = new DoubleSolenoid(RobotMap.HATCH_SOLINOID_1, RobotMap.HATCH_SOLINOID_2);
  }
  public void IntakeIn(){
    IntakeMotor.set(ControlMode.PercentOutput, SPEED_OF_INTAKE);

  }
  public void IntakeOut(){
    IntakeMotor.set(ControlMode.PercentOutput, -SPEED_OF_INTAKE);
  }
  public void IntakeStop(){
    IntakeMotor.stopMotor();;
  }
  public void ReleaseTheKracken(){
    hatchSolenoids.set(Value.kForward);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeStop());
  }
}