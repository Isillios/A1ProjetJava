package model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import static org.junit.Assert.*;

public class DBConnectorTest {

    /**
     * Creation of attribute dbc (DBConnector type)
     * Used in the tests
     */
    LorannDBConnector dbc;

    @Before
    public void setUp() throws Exception {
        /**
         * Initialization of the dbc attribute as the Instance getter
         */
        dbc = LorannDBConnector.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     *  Tests the Instance : it should not be null
     *  @throws SQLException
     */
    @Test
    public void getInstance() throws SQLException {
        assertNotNull("Instance can't be null",dbc);
    }


    /**
     *  Tests the Connection : it should not be null
     *  @throws SQLException
     */
    @Test
    public void getConnection() throws SQLException{
        assertNotNull("Connection can't be null",dbc.getConnection());
    }

}