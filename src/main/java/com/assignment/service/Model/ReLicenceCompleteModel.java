package com.assignment.service.Model;

import com.assignment.service.Dto.ReLicenceCompleteDto;
import com.assignment.service.util.CrudUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReLicenceCompleteModel {

    public void saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException {
        Date date = Date.valueOf(LocalDate.now());

        CrudUtil.execute("insert into ReLicence_Complete values (?,?,?,?)",

                getNextReLicenceComplete(),
                reLicenceCompleteDto.getLastScore(),
                date,
                reLicenceCompleteDto.getDriverId());

    }
    public String getNextReLicenceComplete() throws SQLException {
        ResultSet rst = CrudUtil.execute("select test_id from ReLicence_Complete order by test_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("C%03d", newIdIndex);
        }
        return "C001";
    }

}
