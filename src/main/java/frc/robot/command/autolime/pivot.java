package frc.robot.command.autolime;

import frc.robot.LimelightHelpers;

public class pivot {
    
    final double getSpace(int index) {
        return (LimelightHelpers.getTargetPose_RobotSpace("")[index]);
        //yuckyyuckyyuckyyucky 
    }

//so if robot sees a tag that is rotated it will pivot in the direction of the rotation until the rotation is zero


}
