/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveAutoLeft;
import frc.robot.commands.DriveAutoMiddle;
import frc.robot.commands.DriveAutoRight;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;


public class Robot extends TimedRobot {

  public static Drivetrain m_Drivetrain = null;
  public static OI m_oi;
  public static Lift m_Lift;
  public static Intake m_Intake;
  public static VisionTrackingClient m_visionTrackingClient;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_Drivetrain = new Drivetrain();
    m_oi = new OI();
    m_Lift = new Lift();
    m_Intake = new Intake();
    m_visionTrackingClient = new VisionTrackingClient(RobotMap.RPiPort);

    m_visionTrackingClient.startVisionTrackingClient();

    m_chooser.setDefaultOption("Left Auto", new DriveAutoLeft());
    m_chooser.addOption("Middle Auto", new DriveAutoMiddle());
    m_chooser.addOption("Right Auto", new DriveAutoRight());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
