package main;

import java.io.IOException;
import java.sql.SQLException;


import model.Model;

import view.View;
import controller.Controller;


public abstract class Main 
{
    public static void main(final String[] args) throws IOException, SQLException, InterruptedException
    {
    	
    	final Model lorannmodel = new Model();
    	final View lorannview = new View(lorannmodel.getMap());
        final Controller loranncontroller = new Controller(lorannview, lorannmodel);
        lorannview.setOrderPerformer(loranncontroller.getOrderPeformer());
        loranncontroller.start();
        
    }
}
