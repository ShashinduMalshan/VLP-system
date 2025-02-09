package com.assignment.service.DAO;


import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T>{


    ArrayList<T> getAll() throws SQLException;
    boolean save(T Dto) throws SQLException;
    boolean update(T Dto) throws SQLException;
    boolean delete(String Id) throws SQLException;
    String getNextId() throws SQLException;
    ArrayList<String> checkSuspendId() throws SQLException;
    boolean isDuplicateId(String drivingLicNum) throws SQLException ;


}
