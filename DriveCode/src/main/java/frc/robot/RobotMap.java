/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  //Port the Xbox Controller is Connected to
  public static final int xboxControllerPort = 0; 
  

  //TalonSRX's CAN Addresses
  public static final int FrontLeftMotor  = 1;
  public static final int FrontRightMotor = 2;
  
  public static final int xbox_A = 1;
  public static final int xbox_B = 2;
  public static final int xbot_X = 3;
  public static final int xbox_Y = 4;

  public static final int xbox_Right_Bumper = 6;
  public static final int xbox_Left_Bumper = 5;
  public static final int left_Stick = 9;
  public static final int right_Stick = 10;
  public static final int xbox_Left_Trigger = 2;
  public static final int xbox_Right_Trigger = 3;

  //VictorSPX CAN Addresses
  public static final int BackLeftMotor  = 1;
  public static final int BackRightMotor = 2;


  //Linear Actuator
  public static final int MiddleActuator = 3;
  
  public static final int IntakeMotorPort = 4;
  
  public static final int RPiPort = 5804;

  //Compressor 
  public static final int COMPRESSOR = 11;
  
  //Hatch Solinoids
  public static final int HATCH_SOLINOID_1 = 1;
  public static final int HATCH_SOLINOID_2 = 2;
}
