/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftStop;


public class Lift extends Subsystem {
  private final double SPEED_OF_LIFT = 1;
  TalonSRX linearAccuatorMotor = null;

  public Lift() {
    linearAccuatorMotor = new TalonSRX(RobotMap.MiddleActuator);
  }
  public void LiftUp(){
    linearAccuatorMotor.set(ControlMode.PercentOutput, SPEED_OF_LIFT);

  }
  public void LiftDown(){
    linearAccuatorMotor.set(ControlMode.PercentOutput, -SPEED_OF_LIFT);
  }
  public void LiftStop(){
    linearAccuatorMotor.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftStop());
  }
}
