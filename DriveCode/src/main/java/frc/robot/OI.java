/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.FollowVisionTarget;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeReleaseHatch;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftStop;
import frc.robot.commands.LiftUp;

public class OI {
  public Joystick xboxController = new Joystick(RobotMap.xboxControllerPort);
  
  public Button xboxB = new JoystickButton(xboxController, RobotMap.xbox_B);
  public Button xboxY = new JoystickButton(xboxController, RobotMap.xbox_Y);

  public Button xboxRightBumper = new JoystickButton(xboxController, RobotMap.xbox_Right_Bumper);
  public Button xboxLeftBumper = new JoystickButton(xboxController, RobotMap.xbox_Left_Bumper);

  public Button xboxRightTrigger = new JoystickButton(xboxController, RobotMap.xbox_A);
  public Button xboxLeftTrigger = new JoystickButton(xboxController, RobotMap.xbot_X);

  public OI(){

    xboxB.whenPressed(new FollowVisionTarget());
    xboxB.whenReleased(new DriveArcade());
    xboxRightBumper.whenPressed(new LiftUp());
    xboxRightBumper.whenReleased(new LiftStop());
    xboxLeftBumper.whenPressed(new LiftDown());
    xboxLeftBumper.whenReleased(new LiftStop());
    xboxRightTrigger.whenPressed(new IntakeIn());
    xboxRightTrigger.whenReleased(new IntakeStop());
    xboxLeftTrigger.whenPressed(new IntakeOut());
    xboxLeftTrigger.whenReleased(new IntakeStop());
    xboxY.whenPressed(new IntakeReleaseHatch());
  }
}

