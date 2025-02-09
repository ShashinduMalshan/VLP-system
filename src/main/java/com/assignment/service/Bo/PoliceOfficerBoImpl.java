package com.assignment.service.Bo;

import com.assignment.service.DAO.Custom.Impl.PoliceOfficerImpl;
import com.assignment.service.DAO.Custom.PoliceOfficerDAO;
import com.assignment.service.Model.PoliceOfficerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PoliceOfficerBoImpl {

    PoliceOfficerDAO policeOfficerImpl  = new PoliceOfficerImpl();


    public ArrayList<PoliceOfficerDto> loadTable() throws SQLException {

        return policeOfficerImpl.getAll();
    }



    public boolean delete(String OfficerId) throws SQLException {

        return policeOfficerImpl.delete(OfficerId);
    }


    public boolean update(PoliceOfficerDto policeOfficerDto) throws SQLException {

        return policeOfficerImpl.update(policeOfficerDto);
    }


    public boolean save(PoliceOfficerDto policeOfficerDto) throws SQLException {

            return policeOfficerImpl.save(policeOfficerDto);
        }



    }
