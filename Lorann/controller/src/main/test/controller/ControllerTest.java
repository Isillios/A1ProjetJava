package controller;

import model.ILorannModel;
import model.IMap;
import model.IMobile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.IViewFacade;

import static org.junit.Assert.*;

public class ControllerTest {

    /**
     *
     */
    private Controller controller;

    /**
     *
     */
    private ILorannModel model = new ILorannModel() {
        @Override
        public IMap getMap() {
            return null;
        }

        @Override
        public IMobile getHero() {
            return null;
        }

        @Override
        public IMobile getDemon1() {
            return null;
        }

        @Override
        public IMobile getDemon2() {
            return null;
        }

        @Override
        public IMobile getDemon3() {
            return null;
        }

        @Override
        public IMobile getDemon4() {
            return null;
        }

        @Override
        public void setHero(IMobile her) {

        }

		@Override
		public IMobile getMyPlayer() {
			// TODO Auto-generated method stub
			return null;
		}
    };

    /**
     *
     */
    private IViewFacade viewFacade = new IViewFacade() {
        @Override
        public void refresh() {

        }

        @Override
        public void displayMessage(String message) {

        }
    };

    /**
     *
     */
    private IMap map;

    @Before
    public void setUp() throws Exception {
        this.controller = new Controller(viewFacade, model);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @throws UnknownError
     */
    @Test
    public void testGetModel() throws UnknownError {
        final ILorannModel expectedModel = model;
        assertSame(expectedModel, controller.getModel());
    }

    /**
     *
     */
    @Test
    public void setStackOrder() {
        final Order expectedOrder = Order.STOP;
        this.controller.setStockOrder(Order.STOP);
        assertEquals(expectedOrder, this.controller.getStockOrder());
    }

    @Test
    public void getStackOrder() {
        final Order expectedOrder = Order.STOP;
        assertEquals(expectedOrder, this.controller.getStockOrder());
    }

    @Test
    public void testOrderPerform() {
        Order userOrder = Order.STOP;
        assertEquals(userOrder, controller.getStockOrder());
        assertSame(userOrder, controller.getStockOrder());
    }

    @Test
    public void testStart() throws NullPointerException{
        final int expectedDirection = 1;
        try {
            controller.getModel().getHero().move(expectedDirection);
        } catch(Exception e) {
            System.err.println("Your exception is the following : "+ e.getMessage());
        }
        if (controller.getStockOrder() == Order.UP && expectedDirection != 1){
            fail("The direction should correspond to UP.");
        }
    }
}
