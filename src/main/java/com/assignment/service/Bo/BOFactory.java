package com.assignment.service.Bo;

import com.assignment.service.Bo.custom.DriverBo;
import com.assignment.service.Bo.custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    
    public static BOFactory getDaoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    
    public enum BoTypes{
        DRIVER, POLICE_OFFICER,REVENUE_LIC,SUSPEND_LIC,TRAFFIC_VIOLATION_LAW,TRAINING,VEHICLE,OWNERS,VIOLATION_POINT

    }
    
    public SuperBo getBo(BoTypes boTypes){
        switch (boTypes){
            case DRIVER:
                return new DriverBoImpl();

            case POLICE_OFFICER:
                return new PoliceOfficerBoImpl();

            case REVENUE_LIC:
                return new RevenueLicBoImpl();

            case SUSPEND_LIC:
                return new  SuspendedLicBoImpl();

            case TRAFFIC_VIOLATION_LAW:
                return new TrafficViolationLawBoImpl();

            case TRAINING:
                return new TrainingBoImpl();

            case VEHICLE:
                return new VehicleBoImpl();

            case OWNERS:
                return new VehicleOwnerBoImpl();

            case VIOLATION_POINT:
                return new ViolationPointBoImpl();

            default: return null;
        }
    }
    
}
