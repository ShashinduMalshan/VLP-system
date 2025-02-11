package com.assignment.service.Bo;

import com.assignment.service.Bo.custom.DriverBo;
import com.assignment.service.Bo.custom.Impl.DriverBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    
    public static BOFactory getDaoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    
    public enum BoTypes{
        DRIVER
    }
    
    public SuperBo getBo(BoTypes boTypes){
        switch (boTypes){
            case DRIVER: return new DriverBoImpl();
          
            default: return null;
        }
    }
    
}
