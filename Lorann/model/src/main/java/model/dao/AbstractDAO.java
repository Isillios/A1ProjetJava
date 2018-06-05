package model.dao;

import java.sql.CallableStatement;

/**
 * <h1>The Class AbstractDAO.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class AbstractDAO {
	protected static CallableStatement prepareCall(final String query) {     
		return LorannDBConnector.getInstance().prepareCall(query);
	}
}