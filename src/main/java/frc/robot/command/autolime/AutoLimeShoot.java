package frc.robot.command.autolime;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.LimelightHelpers;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;

public class AutoLimeShoot extends Command {

    private final Shooter shootSub;
    private final Mouth intakeSub;

    public AutoLimeShoot(Shooter shootSub, Mouth intakeSub) {
        this.shootSub = shootSub;
        this.intakeSub = intakeSub;
    }

    // plan:
    // intakes note until limit switch is triggered or until certain number of
    // rotations,
    // spin up the shooter wheels, either in parallel with the intake or after the
    // note has been eaten (limit switch is true)
    // once shooter wheels speed is the right amount for each target the intake will
    // start again and send it into the wheels
    // in fact the 1st intake wheels dont need to move for this it can just be the
    // transport
    // to make auto know when to end: we could

    @Override
    public void execute() {
        double tagID = LimelightHelpers.getFiducialID("");

        intakeSub.eat();

        if (true/* get limit switch */) {
            intakeSub.intakeOff();
        }

        // if(/*tagID == amp*/){
        // shootSub.shootAmp();
        // }
        // else if(/*tagID = speaker*/){
        // shootSub.shootSpeaker();
        // }

        switch ((int) tagID) {
            // first case would be april id that corresponds to amp
            case 1:
                shootSub.shootAmp();
                // second case would be april id that cooresponds to speaker
            case 2:
                shootSub.shootSpeaker();
        }

    }

    @Override
    public void end(boolean interrupted) {
        shootSub.turnOff();
        intakeSub.intakeOff();
    }

    @Override
    public boolean isFinished() {
        return false;

    }

}
