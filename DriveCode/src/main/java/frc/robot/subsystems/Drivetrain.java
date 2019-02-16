/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.DriveTank;
/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  WPI_TalonSRX leftFrontTalon = null;
  WPI_TalonSRX rightFrontTalon = null;
  WPI_VictorSPX leftBackVictor = null;
  WPI_VictorSPX rightBackVictor = null;
  public int driveModeCommand = 1; // 1: Arcade 2: Tank
  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    leftFrontTalon = new WPI_TalonSRX(RobotMap.FrontLeftMotor);
    rightFrontTalon = new WPI_TalonSRX(RobotMap.FrontRightMotor);
    leftBackVictor = new WPI_VictorSPX(RobotMap.BackLeftMotor);
    rightBackVictor = new WPI_VictorSPX(RobotMap.BackRightMotor);
  
    leftFrontTalon.setInverted(false);
    rightFrontTalon.setInverted(false);
    leftBackVictor.setInverted(false);
    rightBackVictor.setInverted(false);

    leftBackVictor.follow(leftFrontTalon);
    rightBackVictor.follow(rightFrontTalon);

    differentialDrive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);
  }
  public void arcadeDrive(double moveY,double rotateX){
    differentialDrive.arcadeDrive(moveY, rotateX);
  }

  public void tankDrive(double kleft_Y, double kright_Y){
    differentialDrive.tankDrive(kleft_Y, kright_Y);
  }
  
  public void setDriveModeCommand(int driveModeCommand) {  
    if (this.driveModeCommand != driveModeCommand) {
      this.driveModeCommand = driveModeCommand;
      if(driveModeCommand == 1){
        Robot.m_oi.xboxB.whenReleased(new DriveArcade());
      }
      else if(driveModeCommand == 2){
        Robot.m_oi.xboxB.whenReleased(new DriveTank());
      }  
    }
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
    setDriveModeCommand(1);
  }

}