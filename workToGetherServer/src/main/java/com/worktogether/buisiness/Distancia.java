package com.worktogether.buisiness;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.jdbc.Work;

public class Distancia implements Work {
	
	private double distancia;
	private BigDecimal latitudeA;
	private BigDecimal longitudeA;
	private BigDecimal latitudeB;
	private BigDecimal longitudeB;
	
	
	public Distancia (BigDecimal latitudeA, BigDecimal longitudeA, BigDecimal latitudeB, BigDecimal longitudeB){
		this.latitudeA = latitudeA;
		this.longitudeA = longitudeA;
		this.latitudeB = latitudeB;
		this.longitudeB = longitudeB;
	}
	

	public void execute(Connection connection) throws SQLException {
		String query ="{? = call sf_distancia_entre_coordenadas(?, ?, ?, ?)}";
		CallableStatement statement = connection.prepareCall(query);
		statement.registerOutParameter(1,java.sql.Types.DOUBLE);
		statement.setBigDecimal(2, latitudeA);
		statement.setBigDecimal(3, longitudeA);
	    statement.setBigDecimal(4, latitudeB);
	    statement.setBigDecimal(5, longitudeB);
		statement.execute();
		
		BigDecimal d = statement.getBigDecimal(1);
		
		if(d != null){
			distancia = d.doubleValue();
		}else{
			distancia = -1d;
		}
		
		statement.close();
	}


	public double getDistancia() {
		return distancia;
	}
	
}
