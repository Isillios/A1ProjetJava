package controller;

import java.io.IOException;
import controller.IOrderPerformer;
import controller.Order;
import model.ILorannModel;
import model.IMobile;
import model.Permeability;
import model.Score;
//import model.element.mobile.*;
import view.IViewFacade;



	public class Controller implements IController , IOrderPerformer {

    private IViewFacade  viewFacade;
    private  ILorannModel model;
    private static int speed = 200;
    private Order stackOrder;
    boolean end;
    static boolean oui;
    private IMobile TheMobile;
	
    
    public Controller(final IViewFacade viewFacade, final ILorannModel model) {
    	this.setViewFacade(viewFacade);
        this.setModel(model);
        this.clearStockOrder();
    }
    
    private void setViewFacade(final IViewFacade viewFacade) {
        this.viewFacade = viewFacade;
    }
    
    @SuppressWarnings("unused")
	private  IViewFacade getViewFacade() {
    	return viewFacade;
    };
    
	private void setModel(ILorannModel model) {
		this.model = model;
	}
	
	public ILorannModel getModel() {
		return this.model;
	}

	public void setStockOrder(Order stackOrder) {
		this.stackOrder = stackOrder; 
	}
	
	public Order getStockOrder() {
		return stackOrder;
	}
	
	private void clearStockOrder() {
	        this.stackOrder = Order.STOP;
	    }
	
	@Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }
	
	@Override
	public void orderPerform(Order userOrder) throws IOException {
		this.setStockOrder(userOrder);
	}
	
	
	@Override
	public void start() throws InterruptedException {
		while (getModel().getMyPlayer().isAlive()) {
            Thread.sleep(speed);
            //System.out.println(TheMobile.getWin());
            switch (this.getStockOrder()) {
            case UP:
            	getModel().getMyPlayer().move(1); 
                viewFacade.refresh();
                break;
            case DOWN:
                getModel().getMyPlayer().move(2);
                viewFacade.refresh();
                break;
            case RIGHT:
            	getModel().getMyPlayer().move(4);
            	viewFacade.refresh();
                    break;
            case LEFT:
                   getModel().getMyPlayer().move(3);
                   viewFacade.refresh();
                    break;
            case SHOOT:
            	if (getModel().getMyPlayer().getMana() == true) { 
            		getModel().getMyPlayer().move(5);
            		getModel().getMyPlayer().setMana(false); 
            		break;}
            case STOP:	
            	break;   
            }
            this.clearStockOrder();
            getModel().getDemon1().move(1);
            getModel().getDemon2().move(1);
            getModel().getDemon3().move(1);
            getModel().getDemon4().move(1);
            viewFacade.refresh();
                 }
		/*if (TheMobile.getWin() == true) {
			*viewFacade.displayMessage("You won with a score of  " + Score.getScore());
		}*/
		{viewFacade.displayMessage("Game Over ! Your score is " + Score.getScore());}
    }

		
	}


