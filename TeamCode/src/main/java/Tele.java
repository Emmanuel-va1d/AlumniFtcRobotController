import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="teleop")
public class Tele extends OpMode {

    private DcMotor leftDrive  = null;
    private DcMotor rightDrive = null;
    private DcMotor arm = null;
    private DcMotor claw = null;

    @Override
    public void init() {
        leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        arm = hardwareMap.get(DcMotor.class, "arm");
        claw = hardwareMap.get(DcMotor.class, "claw");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        claw.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {

        if (Math.abs(gamepad1.left_stick_y) > 0.1)
            leftDrive.setPower(gamepad1.left_stick_y);
        else
            leftDrive.setPower(0);

        if (Math.abs(gamepad1.right_stick_y) > 0.1)
            rightDrive.setPower(gamepad1.right_stick_y);
        else
            rightDrive.setPower(gamepad1.right_stick_y);

        if (gamepad1.dpad_up)
            arm.setPower(0.5);
        else
            arm.setPower(0);

        if (gamepad1.dpad_down)
            arm.setPower(-0.5);
        else
            arm.setPower(0);

        if (gamepad1.right_bumper)
            claw.setPower(1);
        else
            claw.setPower(0);

        if (gamepad1.left_bumper)
            claw.setPower(-1);
        else
            claw.setPower(0);

    }

}
