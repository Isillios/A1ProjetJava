package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ILorannModel;
import model.IMap;


public  class MapDAO extends AbstractDAO {

	private static ILorannModel model;
	private IMap map;
	private static String sqlMapById = "{call getmap1(?)}";
	public int positionhero;
	public int positiondemon1,positiondemon2,positiondemon3,positiondemon4;
	public int purse;

	public MapDAO(IMap map) throws SQLException{
		this.setMap(map);
		getMapById(1);
	}

	private void setMap(IMap map) {
		this.map = map;
	}
	
	public  void getMapById(final int id) throws java.sql.SQLException {
		int i=0;
		final CallableStatement call = prepareCall(sqlMapById);	
		try {
			call.setInt(1, id);
			if(call.execute()) {
				final ResultSet rs = call.getResultSet();
				if(rs.first()) {
					do {
						char Bufferchar = rs.getString("map").charAt(0);
						map.setOnMap(i , Bufferchar);
						switch(Bufferchar) {
						case 'U' :
							this.positionhero = i;
							break;
						case 'M' : 
							this.positiondemon1 = i;
						break;
						case 'm' :
							this.positiondemon2 = i;
							break;
						case 'N' :
							this.positiondemon3 = i;
							break;
						case 'n' :
							this.positiondemon4 = i;	
							break;
						}
						i++;
					}while(rs.next());
				}
				rs.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ILorannModel getModel() {
		return model;
	}

	public static void setModel(ILorannModel model) {
		MapDAO.model = model;
	}
}