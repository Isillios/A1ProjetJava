package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>The Class LorannDBConnector.</h1>
 * 
 * @author Team12
 * @version final
 */

final class LorannDBConnector {
	
	/**
	 * The user's name
	 */
	private static String user = "root";
	
	/**
	 * The password 
	 */
	private static String password = "";
	
	/**
	 * The url of this database
	 */
	private static String url = "jdbc:mysql://localhost/projetjava?useSSL=false&serverTimezone=UTC";
	
	/**
	 * The connection
	 */
	private java.sql.Connection connection;
	
	/**
	 * The statement
	 */
	private java.sql.Statement statement;
	
	/**
	 * The instance of LDBC
	 */
	private static LorannDBConnector instance;

	/**
	 * Open the connector
	 */
	private LorannDBConnector() {
        this.open();
    }
	
	/**
	 * 
	 * @return instance
	 */
	public static LorannDBConnector getInstance() {
		if (instance == null) {
            setInstance(new LorannDBConnector());
        }
        return instance;
	}

	/**
	 * Set the instance
	 * @param instance
	 */
	private static void setInstance(final LorannDBConnector instance) {
		LorannDBConnector.instance = instance;
	}

	/**
	 * Open or not the DB
	 * @return true
	 * @reurn false
	 */
	private boolean open() {
		try {
            this.connection = DriverManager.getConnection(LorannDBConnector.url, LorannDBConnector.user,
                    LorannDBConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } 
		catch (final SQLException exception) {
            exception.printStackTrace();
        }return false;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 
	 * @return this.connection
	 */
	public java.sql.Connection getConnection() {
		return this.connection;
	}

	/**
	 * 
	 * @param connection
	 */
	public void setConnection(final java.sql.Connection connection) {
		this.connection = connection;
	}

	/**
	 * 
	 * @return this.statement
	 */
	public java.sql.Statement getStatement() {
		return this.statement;
	}

	/**
	 * 
	 * @param statement
	 */
	public void setStatement(final java.sql.Statement statement) {
		this.statement = statement;
	}

}