package com.assignment.service.Bo;

import com.assignment.service.Bo.custom.DriverBo;
import com.assignment.service.Bo.custom.Impl.DriverBoImpl;

public class BOFactory {
    private static BOFactory daoFactory;

    private BOFactory() {
    }
    
    public static BOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new BOFactory() : daoFactory;
    }
    
    public enum BoTypes{
        DRIVER
    }
    
    public SuperBo getDAO(BoTypes boTypes){
        switch (boTypes){
            case DRIVER: return new DriverBoImpl();
          
            default: return null;
        }
    }
    
}
