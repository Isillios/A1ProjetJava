package controller;

import java.io.IOException;
import controller.IOrderPerformer;
import controller.Order;
import model.ILorannModel;
import model.IMobile;
import model.Score;
import view.IViewFacade;

/**
 * <h1>The Class Controller .</h1>
 * <p>
 * This Class allows to make the link between the view and the model. 
 * </p>
 * @author Team12
 * @version final
 * @see IController
 * @see IViewFacade
 * @see ILorannModel
 * @see Order
 * @see IMobile
 */

	public class Controller implements IController , IOrderPerformer {

	/**
	 * The view facade
	*/
    private IViewFacade viewFacade;
    
    /**
     * The model
     */
    private  ILorannModel model;
    
    /**
     * The player's speed
     */
    private static int speed = 100;
    
    /**
     * The stock of the order
     */
    private Order stockOrder;
    
    /**
     * The attribute for the method win
     */
    static boolean yes;
    
    /**
     * The mobile
     */
    private IMobile TheMobile;
	
    /**
     * 
     * @param viewFacade
     * @param model
     */
    public Controller(final IViewFacade viewFacade, final ILorannModel model) {
    	/**
    	 * Set the view facade
    	 */
    	this.setViewFacade(viewFacade);
    	/**
    	 * Set the model
    	 */
        this.setModel(model);
        /**
         * clear the stock of order
         */
        this.clearStockOrder();
    }
    
    /**
     * 
     * @param viewFacade
     */
    private void setViewFacade(final IViewFacade viewFacade) {
        this.viewFacade = viewFacade;
    }
   
    /**
     * 
     * @return viewFacade
     */
    @SuppressWarnings("unused")
	private  IViewFacade getViewFacade() {
    	return viewFacade;
    };
    
    /**
     * 
     * @param model
     */
	private void setModel(ILorannModel model) {
		this.model = model;
	}
	
	/**
	 * 
	 * @return
	 */
	public ILorannModel getModel() {
		return this.model;
	}

	/**
	 * To stock the order of the player
	 * @param stockOrder
	 */
	public void setStockOrder(Order stockOrder) {
		this.stockOrder = stockOrder; 
	}
	
	/**
	 * 
	 * To get the stock's order of the player
	 * @return stockOrder
	 */
	public Order getStockOrder() {
		return stockOrder;
	}
	
	/**
	 * Clean the stock order
	 */
	private void clearStockOrder() {
	        this.stockOrder = Order.STOP;
	    }
	
	/**
	 * 
	 */
	@Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }
	
	/**
	 * 
	 */
	@Override
	public void orderPerform(Order userOrder) throws IOException {
		this.setStockOrder(userOrder);
	}
	
	/**
	 * This method Start the game
	 */
	@Override
	public void start() throws InterruptedException {
		/**
		 * While the player is alive
		 */
		while (getModel().getMyPlayer().isAlive() && getModel().getMyPlayer().getWin() == false) {
            Thread.sleep(speed);
            //System.out.println(TheMobile.getWin());
           /**
            * Verified the order 
            */
            switch (this.getStockOrder()) {
            case UP:
            	/**
            	 * Launch moveUp in the model
            	 */
            	getModel().getMyPlayer().move(1); 
                viewFacade.refresh();
                break;
            case DOWN:
            	/**
            	 * Launch moveDown in the model
            	 */
                getModel().getMyPlayer().move(2);
                viewFacade.refresh();
                break;
            case RIGHT:
            	/**
            	 * Launch moveRight in the model
            	 */
            	getModel().getMyPlayer().move(4);
            	viewFacade.refresh();
                    break;
            case LEFT:
            	/**
            	 * Launch moveLeft in the model
            	 */
                   getModel().getMyPlayer().move(3);
                   viewFacade.refresh();
                    break;
                    
            case UPRIGHT :
            	getModel().getMyPlayer().move(6);
            	viewFacade.refresh();
                    break;
            case UPLEFT :
            	getModel().getMyPlayer().move(7);
                viewFacade.refresh();
            	break;
            case DOWNRIGHT :
            	getModel().getMyPlayer().move(8);
                viewFacade.refresh();
            	break;
            case DOWNLEFT :
            	getModel().getMyPlayer().move(9);
                viewFacade.refresh();
            	break;
            	
            case SHOOT:
            	/**
            	 * Launch shoot in the model
            	 * When the player shoot, it looses his mana 
            	 */
            	if (getModel().getMyPlayer().getMana() == true) { 
            		getModel().getMyPlayer().move(5);
            		getModel().getMyPlayer().setMana(false); 
            		break;}
            case STOP:	
            	break;   
            }
            
            /**
             * clear the stock order
             */
            this.clearStockOrder();
            
            /**
             * Launch the methods movement for the demons
             */
            getModel().getDemon1().move(0);
            getModel().getDemon2().move(0);
            getModel().getDemon3().move(0);
            getModel().getDemon4().move(0);
            viewFacade.refresh();
                 }
		
		
		/**
		 * Show a message gameover with your score when the player isn't alive
		 */
		{
			if (getModel().getMyPlayer().getWin() == true) {
				viewFacade.displayMessage("GG ! Your score is " + Score.getScore());
			}
			else {
				viewFacade.displayMessage("Game Over ! Your score is " + Score.getScore());}
			}
    }

	/**
	 * 
	 * @return TheMobile
	 */
	public IMobile getTheMobile() {
		return TheMobile;
	}

	public void setTheMobile(IMobile theMobile) {
		TheMobile = theMobile;
	}

		
	}


