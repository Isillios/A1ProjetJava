package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.IOrderPerformer;
import controller.Order;

import model.IMap;

// verifier le dossier sprite !!

public  class View implements KeyListener , IViewFacade{
	
	private IOrderPerformer orderPerformer;
	public ViewPanel viewpanel;
	public View(IMap map) throws IOException {
		 
		final JFrame frame = new javax.swing.JFrame("LorannGame");
		viewpanel  =  new ViewPanel(map);
		frame.setContentPane(viewpanel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this); 
		frame.requestFocusInWindow(); 
	  }
	
	  private IOrderPerformer getOrderPerformer() {
	        return this.orderPerformer;
	    }
	  
	  public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
	        this.orderPerformer = orderPerformer;
	    }
	 
	  public Order KeyInput(final int key) {
		  Order order = null;
	        switch (key)
	        {
	            case KeyEvent.VK_UP:
	                order = Order.UP;
	                break;
	            case KeyEvent.VK_LEFT:
	            	order = Order.LEFT;
	                break;
	            case KeyEvent.VK_RIGHT:
	            	order = Order.RIGHT;
	                break;
	            case KeyEvent.VK_DOWN:
	            	order = Order.DOWN;
	                break;
	            case KeyEvent.VK_SPACE:
	            	order = Order.SHOOT;
	                break;
	            default:
	                System.out.println("The key doesn't exist");
	                order = Order.STOP;
	        }
	        return order;
	  }
  	
	  public void keyTyped(KeyEvent e) {
	  }
	  
	  public void keyPressed(final KeyEvent e) {
	            try {
	            	this.getOrderPerformer().orderPerform(KeyInput(e.getKeyCode()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
	  }
			
		
	  public void keyReleased(KeyEvent e) {
	  }
		
	  @Override
	  public void displayMessage(String message) {	
		  JOptionPane.showMessageDialog(null, message);
	  }

	  @Override
	  public void refresh() {
		  viewpanel.repaint();
	  }
}
