package view;

import controller.Order;
import model.IMap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;


import static org.junit.Assert.*;

public class ViewTest {

    /**
     * Creation of attribute map (IMap type)
     * Used inside the tests
     */
    private IMap map;

    /**
     * Creation of attribute testview (view type)
     * Used inside the tests
     */
    private View testView;

    /**
     * Creation of attribute panel (viewpanel type)
     * Used inside the tests
     */
    private ViewPanel panel;

    /**
     * Creation of new object view, named testview
     * Used inside the tests
     * @param map The map
     */
    {
        try {
            testView = new View(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Before
    public void setUp() throws Exception {
        /**
         * Creation of new object viewpanel, named panel
         * @param map The map
         */
        panel = new ViewPanel(map);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test to make sure that our Order is the same one as the one called when having the input
     * @throws NullPointerException
     */
    @Test
    public void testInputTouch() throws NullPointerException {
        assertEquals(Order.UP, testView.KeyInput(KeyEvent.VK_Z));
    }

    /**
     * Tests if InputTouch returned the value we expected.
     * @throws IOException
     */
    @Test
    public void OrderTest_OK() throws IOException {
        testView = new View(map);
        Order testOrder = testView.KeyInput(KeyEvent.VK_Z);
        Assert.assertEquals(testOrder, Order.UP);
    }

    /**
     * Test made to return a message when there is no map given.
     * @throws Exception
     */
    @Test
    public void testGenerateViewWithoutMap() throws Exception{
        try {
            testView = new View(null);
            fail( "My method didn't throw when I expected it" );
            } catch (Error expectedError) {
            System.err.println("Your error is the following :" + expectedError.getMessage());
            assertNotNull(expectedError);
            }
    }
}
