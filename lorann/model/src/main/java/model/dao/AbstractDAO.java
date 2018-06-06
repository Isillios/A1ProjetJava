package model.dao;

import java.sql.CallableStatement;

/**
 * <h1>The Class AbstractDAO.</h1>
 * 
 * @author Team12
 * @version final
 */
public abstract class AbstractDAO {
	
	/**
	 * 
	 * @param query
	 * @return LorannDBConnector.getInstance().prepareCall(query)
	 */
	protected static CallableStatement prepareCall(final String query) {     
		return LorannDBConnector.getInstance().prepareCall(query);
	}
}