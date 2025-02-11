package com.assignment.service.DAO;

import com.assignment.service.DAO.Custom.Impl.*;
import com.assignment.service.DAO.Custom.RegistrationDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    
    public enum DAOTypes{
        DRIVER, POLICE_OFFICER,REVENUE_LIC,SUSPEND_LIC,TRAFFIC_VIOLATION_LAW,TRAINING,VEHICLE,OWNERS,VIOLATION_POINT,REGISTRATION,RELICENCE_COMPLETE
    }
    
    public CrudDAO getDAO(DAOTypes daoTypes){

        switch (daoTypes){
            case DRIVER:
                return new DriverImpl();


            case POLICE_OFFICER:
                return new PoliceOfficerImpl();

            case REVENUE_LIC:
                return new RevenueLicImpl();

            case SUSPEND_LIC:
                return new SuspendLicImpl();

            case TRAFFIC_VIOLATION_LAW:
                return new TrafficViolationLawImpl();

            case TRAINING:
                return new TrainingImpl();

            case VEHICLE:
                return new VehicleImpl();

            case OWNERS:
                return new VehicleOwnerImpl();

            case VIOLATION_POINT:
                return new ViolationPointImpl();

            case REGISTRATION:
                return new RegisterImpl();

            case RELICENCE_COMPLETE:
                return new ReLicenceCompleteImpl();

            default:
                return null;
        }
    }
    
}
