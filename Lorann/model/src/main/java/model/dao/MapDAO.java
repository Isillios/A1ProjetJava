package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ILorannModel;
import model.IMap;

/**
 * <h1>The Class MapDAO.</h1>
 * 
 * @author Team12
 * @version final
 */

public  class MapDAO extends AbstractDAO {

	/**
	 * The model
	 */
	private static ILorannModel model;
	/**
	 * The map
	 */
	private IMap map;
	/**
	 * Call the procedure
	 */
	private static String sqlMapById = "{call getmap1(?)}";
	/**
	 * The hero's position
	 */
	public int positionhero;
	/**
	 * The demon's position
	 */
	public int positiondemon1,positiondemon2,positiondemon3,positiondemon4;
	/**
	 * The purse
	 */
	public int purse;

	/**
	 * 
	 * @param map
	 * @throws SQLException
	 */
	public MapDAO(IMap map) throws SQLException{
		this.setMap(map);
		getMapById(1);
	}

	/**
	 * 
	 * @param map
	 */
	private void setMap(IMap map) {
		this.map = map;
	}
	
	/**
	 * Generate map using a id for each character
	 * @param id
	 * @throws java.sql.SQLException
	 */
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
						/**
						 * Lorann
						 */
						case 'U' :
							this.positionhero = i;
							break;
						/**
						 * Demon1
						 */
						case 'M' : 
							this.positiondemon1 = i;
						break;
						/**
						 * Demon2
						 */
						case 'm' :
							this.positiondemon2 = i;
							break;
						/**
						* Demon3
						*/
						case 'N' :
							this.positiondemon3 = i;
							break;
						/**
						* Demon4
						*/
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

	/**
	 * 
	 * @return model
	 */
	public static ILorannModel getModel() {
		return model;
	}

	/**
	 * Set the model
	 * @param model
	 */
	public static void setModel(ILorannModel model) {
		MapDAO.model = model;
	}
}