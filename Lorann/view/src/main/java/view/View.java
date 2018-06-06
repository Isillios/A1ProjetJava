package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.IOrderPerformer;
import controller.Order;
import model.IMap;


/**
 * <h1>The Class View.</h1>
 * <p>This class View implements the keyListenner and the facade. 
 * @author Team12
 * @version final
 * @see KeyListener
 * @see IViewFacade
 */

public  class View implements KeyListener , IViewFacade{
	
	/**
	 * The orderPerformer
	 */
	private IOrderPerformer orderPerformer;
	
	/**
	 * The viewpanel
	 */
	public ViewPanel viewpanel;
	
	/**
	 * Create the frame
	 * @param map
	 * @throws IOException
	 */
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
	 
	  /**
	   * Stock the key input in an attribute
	   * @param key
	   * @return
	   */
	  public Order KeyInput(final int key) {
		  Order order = null;
	        switch (key)
	        {
	            case KeyEvent.VK_NUMPAD8:
	                order = Order.UP;
	                break;
	            case KeyEvent.VK_NUMPAD4:
	            	order = Order.LEFT;
	                break;
	            case KeyEvent.VK_NUMPAD6:
	            	order = Order.RIGHT;
	                break;
	            case KeyEvent.VK_NUMPAD2:
	            	order = Order.DOWN;
	                break;
	            case KeyEvent.VK_SPACE:
	            	order = Order.SHOOT;
	                break;
	            case KeyEvent.VK_NUMPAD9:
	            	order = Order.UPRIGHT;
	            	break;
	            case KeyEvent.VK_NUMPAD7:
	            	order = Order.UPLEFT;
	            	break;
	            case KeyEvent.VK_NUMPAD1:
	            	order = Order.DOWNRIGHT;
	            	break;
	            case KeyEvent.VK_NUMPAD3:
	            	order = Order.DOWNLEFT;
	            	break;
	            default:
	                System.out.println("The key doesn't exist");
	                order = Order.STOP;
	        }
	        return order;
	  }
  	
	  public void keyTyped(KeyEvent e) {
	  }
	  
	  /**
	   * When a key is pressed
	   */
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

	  /**
	   * Repaint the frame
	   */
	  @Override
	  public void refresh() {
		  viewpanel.repaint();
	  }
}
