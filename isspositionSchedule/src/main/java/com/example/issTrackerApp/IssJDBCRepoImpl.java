package com.example.issTrackerApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IssJDBCRepoImpl implements IssRepository{

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public int saveIssPos(Iss iss) {
		
		return jdbcTemplate.update("INSERT INTO ISS (timestamp,message,longitude,latitude) VALUES(?,?,?,?)",
				iss.getTimestamp(),iss.getMessage(),iss.getLongitude(),iss.getLatitude());
	}

	@Override
	public List<Iss> showAllissPos() {
		
		return jdbcTemplate.query(
                "select * from ISS",
                (rs, rowNum) ->
                        new Iss(
                                rs.getInt("timestamp"),
                                rs.getString("message"),
                                rs.getFloat("latitude"),
                                rs.getFloat("longitude")
                        )
        );
	}

	@Override
	public List<Iss> showLast10issPos() {
		return jdbcTemplate.query(
                "select * from ISS ORDER BY timestamp DESC LIMIT 10",
                (rs, rowNum) ->
                        new Iss(
                                rs.getInt("timestamp"),
                                rs.getString("message"),
                                rs.getFloat("latitude"),
                                rs.getFloat("longitude")
                        )
        );
	}

	
	
}
