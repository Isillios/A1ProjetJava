package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;


final class LorannDBConnector {
	
	private static String user = "root";
	
	private static String password = "";
	
	private static String url = "jdbc:mysql://localhost/projetjava?useSSL=false&serverTimezone=UTC";
	
	private java.sql.Connection connection;
	
	private java.sql.Statement statement;
	
	private static LorannDBConnector instance;

	private LorannDBConnector() {
        this.open();
    }
	
	public static LorannDBConnector getInstance() {
		if (instance == null) {
            setInstance(new LorannDBConnector());
        }
        return instance;
	}

	
	private static void setInstance(final LorannDBConnector instance) {
		LorannDBConnector.instance = instance;
	}

	
	private boolean open() {
		try {
            this.connection = DriverManager.getConnection(LorannDBConnector.url, LorannDBConnector.user,
                    LorannDBConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }return false;
	}

	public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public java.sql.Connection getConnection() {
		return this.connection;
	}

	public void setConnection(final java.sql.Connection connection) {
		this.connection = connection;
	}

	public java.sql.Statement getStatement() {
		return this.statement;
	}

	public void setStatement(final java.sql.Statement statement) {
		this.statement = statement;
	}

}