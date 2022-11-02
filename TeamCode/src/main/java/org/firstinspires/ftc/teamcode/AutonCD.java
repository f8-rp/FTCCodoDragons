/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;



@Autonomous(name="CodoDragonsAutonomous", group="Autonomous")
public class AutonCD extends LinearOpMode {

    @Override
    public void runOpMode() {
        RobotHardware robot    = new RobotHardware(HardwareMap);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run once in the match
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
        // go in front of da high junction usinnng da move functions
        //go
    }

    void MoveForward(double pwr, double sleepTime){
        robot.front_left.setPower(pwr);
        robot.front_right.setPower(pwr);
        robot.back_left.setPower(pwr);
        robot.back_right.setPower(pwr);
        telemetry.sleep(sleepTime);
        robot.front_left.setPower(0);
        robot.front_right.setPower(0);
        robot.back_left.setPower(0);
        robot.back_right.setPower(0);
    }
    void MoveLeft(double pwr, double sleepTime){
        robot.front_left.setPower(-pwr);
        robot.front_right.setPower(pwr);
        robot.back_left.setPower(pwr);
        robot.back_right.setPower(-pwr); 
        telemetry.sleep(sleepTime);
        robot.front_left.setPower(0);
        robot.front_right.setPower(0);
        robot.back_left.setPower(0);
        robot.back_right.setPower(0);
    }
    void MoveRight(double pwr, double sleepTime){
        robot.front_left.setPower(pwr);
        robot.front_right.setPower(-pwr);
        robot.back_left.setPower(-pwr);
        robot.back_right.setPower(pwr);
        telemetry.sleep(sleepTime);
        robot.front_left.setPower(0);
        robot.front_right.setPower(0);
        robot.back_left.setPower(0);
        robot.back_right.setPower(0);
    }
    void MoveBack(double pwr, double sleepTime){
        robot.front_left.setPower(-pwr);
        robot.front_right.setPower(-pwr);
        robot.back_left.setPower(-pwr);
        robot.back_right.setPower(-pwr);
        telemetry.sleep(sleepTime);
        robot.front_left.setPower(0);
        robot.front_right.setPower(0);
        robot.back_left.setPower(0);
        robot.back_right.setPower(0);
    }
    
    
    void linSlide(double pwr){
        slide.setPower(pwr);
    }  
    
    void contractClaw(double open,double sleepTime){
        robot.claw.setPosition(open);
        telemetry.sleep(sleepTime);
    }
    
    void medJunc(double sleepTime, double pwr){
        //open and close the claw
        //0 for open & 100 for close
        telemetry.sleep(sleepTime);
        contractClaw(100,100);
        //Bring Linear Slide Up
        linSlide(pwr);
        telemetry.sleep(sleepTime);
        contractClaw(0,100);
        linSlide(0);
    }

    //computer vision functoin then runn park with site!!!!

    void park(string site){
        if(site=="a"){
            //go to a
            MoveLeft(0.6, 100);
            MoveForward(0.6, 100);
        }
        else if(site=="b"){
            //go to b
            MoveRight(0.6, 100);
            MoveForward(0.6, 100);
        }
        if(site=="c"){
            //go to c
            MoveForward(0.6, 100);
        }
    }
    
}
