package com.assignment.service.DAO;

import com.assignment.service.DAO.Custom.Impl.DriverImpl;
import com.assignment.service.DAO.Custom.Impl.PoliceOfficerImpl;
import com.assignment.service.DAO.Custom.Impl.RevenueLicImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    
    public enum DAOTypes{
        DRIVER, PoliceOfficer,REVENUE_LIC
    }
    
    public CrudDAO getDAO(DAOTypes daoTypes){

        switch (daoTypes){
            case DRIVER:
                return new DriverImpl();

            case PoliceOfficer:
                return new PoliceOfficerImpl();

            case REVENUE_LIC:
                return new RevenueLicImpl();



            default:
                return null;
        }
    }
    
}
