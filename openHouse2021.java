package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Activityfairclawshowcase2021 (Blocks to Java)")
public class Activityfairclawshowcase2021 extends LinearOpMode {

  private Servo clawAsServo;
  private Servo heightAsServo;
  private Servo lengthAsServo;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double claw_pos;
    int servostop;
    double height_pos;
    double length_pos;
    double ServoSpeed;

    clawAsServo = hardwareMap.get(Servo.class, "clawAsServo");
    heightAsServo = hardwareMap.get(Servo.class, "heightAsServo");
    lengthAsServo = hardwareMap.get(Servo.class, "lengthAsServo");

    // Set servo to mid position
    claw_pos = 0.8;
    height_pos = 0.62;
    length_pos = 0.56;
    ServoSpeed = 0.02;
    servostop = 0;
    waitForStart();
    while (opModeIsActive()) {
      // Use gamepad X and B to open close servo
      if (gamepad1.b) {
        claw_pos += ServoSpeed;
      } else if (gamepad1.x) {
        claw_pos += -ServoSpeed;
      } else {
        claw_pos += servostop;
      }
      if (gamepad1.dpad_up) {
        height_pos += ServoSpeed;
      }
      if (gamepad1.dpad_down) {
        height_pos += -ServoSpeed;
      }
      if (gamepad1.dpad_right) {
        length_pos += ServoSpeed;
      }
      if (gamepad1.dpad_left) {
        length_pos += -ServoSpeed;
      }
      if (gamepad1.a) {
        height_pos = 0.3;
        claw_pos = 0.8;
        length_pos = 0.95;
      }
      if (gamepad1.y) {
        height_pos = 0.8;
        claw_pos = 0.95;
        length_pos = 0.68;
      }
      // Keep Servo position in valid range
      claw_pos = Math.min(Math.max(claw_pos, 0.8), 0.95);
      height_pos = Math.min(Math.max(height_pos, 0.3), 0.8);
      length_pos = Math.min(Math.max(length_pos, 0.3), 0.95);
      clawAsServo.setPosition(claw_pos);
      heightAsServo.setPosition(height_pos);
      lengthAsServo.setPosition(length_pos);
      telemetry.addData("Claw", claw_pos);
      telemetry.addData("Height", height_pos);
      telemetry.addData("Length", length_pos);
      telemetry.update();
      sleep(20);
    }
  }
}